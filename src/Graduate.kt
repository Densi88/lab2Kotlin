class Graduate(number: Int,
               age: Int,
               name: String,
               group: String) : Student(number, age, name, group) {
    override fun study(){
        explore()
    }
    private fun explore(){
        println("${name} пришел в лабораторию")
        erudition=erudition+10
    }
}