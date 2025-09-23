open class  Student(number: Int, age: Int, name: String, group: String) {
    public var number: Int =0
    public var age: Int=0
    public var name: String=""
    public var group: String=""
    public var erudition: Int=0
    init {
        this.number = number
        this.age = age
        this.name = name
        this.group = group
        println("Создан студент: $name")
    }
    open fun study(){
        println("Studying")
    }
}