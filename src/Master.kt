import java.util.Scanner
import kotlin.random.Random
class Master(number: Int,
             age: Int,
             name: String,
             group: String) : Student(number, age, name, group) {
    val scanner=Scanner(System.`in`)
    override fun study(){
        writeDiploma()
    }
    private fun writeDiploma(){
        println("Диплом пишется[                  ]")
        Thread.sleep(2000)
        println("Диплом пишется[///               ]")
        Thread.sleep(2000)
        println("Диплом пишется[//////            ]")
        Thread.sleep(2000)
        println("Диплом пишется[/////////         ]")
        Thread.sleep(2000)
        println("Правим по госту[/////////////     ]")
        Thread.sleep(2000)
        println("Пишем источники литературы[////////////////// ]")
        Thread.sleep(2000)
        val number=Random.nextInt(2)
        when(number){
            1->{
                println("Ого! Глава диплома написана![////////////////////]")
                erudition=erudition+20
            }
            2->{
                println("О нет! Серышева дала правки и все переделывать((")
                erudition=erudition-10
            }
        }
    }
}