/**
 * Created by zero on 15-11-3.
 */
/**
 * 循环的方式
 */

//for(i in 0..2) { print 'm'+i }
//
//0.upto(2) { print "$it" }
//
//3.times { print "$it" }
//
//0.step(10, 2) { println("$it") }

// 模拟终端输入
//println "ls -l".execute().text


// 安全导航操作符 ?.  防止空引用
//def foo(str) {
//    str?.reverse()
//}
//
//println foo("ZeroBug")

// 异常处理,最后再执行
//new Thread(new Runnable() {
//    @Override
//    void run() {
//        Thread.sleep(3000)
//    }
//}).start()
//
//println foo(null)

// 方法和类默认是公开的（public）
//class Person{
//    def static learn() {
//        println "hehe";
//    }
//}
//
//Person.learn()

// 多赋值
//def splitName(fullName) {
//    fullName.split(' ')
//}
//
//def (first, last) = splitName('James Bond')
//println "$first, $last"

/*
def pullError = "adb pull error.txt /Share/error/"
// 执行命令
println pullError.execute().text
*/

// process = "wc".execute()

// process.out.withWriter {
//     it << "Let the world know...\n"
//     it << "Groovy Rocks!\n"
// }

// println process.in.text












