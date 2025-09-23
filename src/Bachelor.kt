import Student
import kotlin.random.Random
import java.util.Scanner
class Bachelor(number: Int,
               age: Int,
               name: String,
               group: String) : Student(number, age, name, group) {
    override fun study(){
        println("Что будем делать?")
        println("Идти на лекции(1)")
        println("Писать код(2)")
        val scanner=Scanner(System.`in`)
        val number:Int=scanner.nextInt()
        when(number){
            1->listenLections()
            2->writeCode()
        }
    }
    private fun writeCode(){
        var number=Random.nextInt(5)
        when(number){
            1->{
                println("${name} Изучает rapidjson")
                erudition=erudition+2
            }
            2->{
                erudition++
                println("${name} Изучает контейнеры")
            }
            3->{
                println("${name} Пишет бинарное дерево")
                erudition=erudition+4
            }
            4->{
                erudition=erudition+5
                println("${name} Реализует ассинхронные функции")
            }
            5->{
                println("${name} Пишет тесты")
                erudition=erudition+3
            }
        }

    }
    private fun listenLections(){
        val scanner=Scanner(System.`in`)
        var number=Random.nextInt(3)
        var choose: String
        when(number){
            1->{
                println("Сегодня лекция по матану. Пропустить?")
                choose=scanner.next()
                if(choose=="yes"){
                    erudition=erudition-2
                }
                else if(choose=="no"){
                    erudition=erudition+2
                }
            }
            2->{
                println("Сегодня лекция по философии. На нее мы никогда не ходим")
            }
            3->{
                println("Сегодня лекция по паттернам проектирования. На нее мы полюбому идем")
                erudition=erudition+3
            }
        }

    }
}