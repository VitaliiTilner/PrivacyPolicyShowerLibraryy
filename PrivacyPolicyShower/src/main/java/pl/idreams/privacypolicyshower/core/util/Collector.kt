package pl.idreams.privacypolicyshower.core.util


internal class Collector(
    setOfRequireKeys : Set<String>,
    private val cullBack : (Map<String,Any?>) -> Unit,
){
    private val resultMap = mutableMapOf<String,Any?>()
    private val listOfUnusedKeys = setOfRequireKeys.toMutableList()

    fun sendData(key: String,value: Any?){
        if(listOfUnusedKeys.isEmpty()) return

        if(listOfUnusedKeys.contains(key))
            listOfUnusedKeys.remove(key)

        resultMap[key] = value

        checkIfMustToDoCullBack(listOfUnusedKeys.size)
    }

    private fun checkIfMustToDoCullBack(unusedKeysCount : Int){
        if (unusedKeysCount ==0){
            cullBack(resultMap)
        }
    }
}