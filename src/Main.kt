import Student
import java.util.Scanner
val students = mutableListOf<Student>()
fun main() {
    val scanner=Scanner(System.`in`)
    var running:Boolean=true
    while(running){
        printMenu()
        when(scanner.nextInt()){
            1->addStudent()
            2->showStudentList()
            3->currentStudentStudy()
            4->reEnter()
            9->running=false
            else->{
                println("Неверный пункт!")
            }
        }
    }
}
fun printMenu(){
    println("Добавить студента(1)")
    println("Показать список студентов(2)")
    println("Заставить студента учиться(3)")
    println("Перевести студента(4)")
    println("Выход(9)")
}
fun addStudent(){
    val scanner=Scanner(System.`in`)
    println("Введите номер зачетки:")
    val number:Int=scanner.nextInt()
    println("Введите возраст:")
    val age:Int=scanner.nextInt()
    println("Введите имя:")
    val name:String=scanner.next()
    println("Введите группу:")
    val group:String=scanner.next()
    println("Студент бакалавр(1), магистрант(2), аспирант(3)?")
    when(scanner.nextInt()){
        1->{
            val student=Bachelor(number, age, name, group)
            students.add(student)
        }
        2->{
            val student=Master(number, age, name, group)
            students.add(student)
        }
        3->{
            val student=Graduate(number, age, name, group)
            students.add(student)
        }
    }
}
fun showStudentList(){
    if (students.isEmpty()) {
        println("📭 Список студентов пуст")
        return
    }

    println("\n" + "=".repeat(80))
    println("СПИСОК СТУДЕНТОВ")
    println("=".repeat(80))
    println("| №   | Имя           | Возраст | Группа    | Вид |")
    println("-".repeat(80))

    students.forEachIndexed { index, student ->
        println("| ${index + 1}   | ${student.name.padEnd(12)} | ${student.age.toString().padEnd(6)} | ${student.group.padEnd(8)} | ${student::class.simpleName} |")
    }

    println("=".repeat(80))
    println("Всего студентов: ${students.size}")

}
fun currentStudentStudy(){
    val scanner=Scanner(System.`in`)
    println("Введите номер зачетки:")
    val currentNumber:Int=scanner.nextInt()
    val currentStudent=students.find { it.number==currentNumber }
    if (currentStudent != null) {
        currentStudent.study()
    }
}
fun reEnter(){
    println("Введите номер зачетки перепоступающего:")
    val scanner =Scanner(System.`in`)
    var choose:Int
    val currentNumber:Int=scanner.nextInt()
    students.forEach{ student->
        if(student.number==currentNumber){
            println("Куда перепоступаем?")
            println("Бакалавр(1)")
            println("Магистратура(2)")
            println("Аспирантура(3)")
            choose=scanner.nextInt()
            when(choose){
                1->{
                    val newStudent=Bachelor(student.number, student.age, student.name, student.group)
                    students.add(newStudent)
                    students.remove(student)
                    println("Студент переведен!")
                    }
                2->{
                    if(student is Bachelor){
                        val newStudent=Master(student.number, student.age, student.name, student.group)
                        students.add(newStudent)
                        students.remove(student)
                        println("Студент переведен!")
                    }
                    else{
                        println("На магистратуру может перепоступить только бакалавр!")
                        return
                    }
                }
                3->{
                    if(student is Master){
                        val newStudent=Graduate(student.number, student.age, student.name, student.group)
                        students.add(newStudent)
                        students.remove(student)
                        println("Студент переведен!")

                    }
                    else{
                        println("В аспирантуру может пойти только магистр!")
                        return
                    }
                }
            }
        }
        else{
            println("Студент не найден")
        }
    }
}