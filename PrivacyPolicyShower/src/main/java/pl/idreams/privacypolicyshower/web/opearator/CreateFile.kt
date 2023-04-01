package pl.idreams.privacypolicyshower.web.opearator

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

internal class CreateFile {
    @SuppressLint("InlinedApi")
    operator fun invoke(activity: Activity, bmp: Bitmap, isVersionLvlHigh: Boolean): Uri?{
        val imageCollection = when (isVersionLvlHigh) {
            true -> {
                MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
            }
            false -> {
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }
        }
        val timeStamp = SimpleDateFormat.getDateInstance().format(Date())

        val imageFileName = "JPEG_" + timeStamp + "_"

        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, "$imageFileName.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
            put(MediaStore.Images.Media.WIDTH, bmp.width)
            put(MediaStore.Images.Media.HEIGHT, bmp.height)
        }
        var myUri: Uri? = null
        return try {
            activity.contentResolver.insert(imageCollection, contentValues)?.also { uri ->
                activity.contentResolver.openOutputStream(uri).use { outputStream ->
                    if (!bmp.compress(Bitmap.CompressFormat.JPEG, 95, outputStream)) {
                        throw IOException("Photo saving error")
                    }
                    myUri = uri
                }
            } ?: throw IOException("Creating path error")
            myUri
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}