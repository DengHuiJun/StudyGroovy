import groovy.io.FileType
import groovy.io.FileVisitResult

/**
 * 文件相关操作
 * Created by zero on 17-4-13.
 */
def basePath = '/home/zero/groovytest/'
def srcPath = basePath + "src/yunzhijia_369.apk"
def targetPath = basePath + "target/ss.apk"
def fileName = 'readme.txt'

def srcFile = new File(srcPath)
def targetFile = new File(targetPath)

/**
 * 拷贝文件
 */
targetFile.withDataOutputStream {
    os ->
        srcFile.withDataInputStream {
            is -> os << is
        }
}

/**
 * 输出当前目录
 */
println new File(".").absolutePath

/**
 * 读文件操作
 */
// 读文件操作
new File(basePath, fileName).eachLine {
    line -> println(line)
}

new File(basePath, fileName).eachLine {
    line, nb -> println("Line $nb : $line")
}

def count = 0, MAXSIZE = 3
new File(basePath, fileName).withReader {
    reader ->
        while (reader.readLine()) {
            if (++count > MAXSIZE) {
                throw new RuntimeException(".gitignore should only have 3 verses")
            }
        }
}

// 把读到的文件行内容全部存入List列表中
def list = new File(basePath, '.gitignore').collect {
    it
}

// 把读到的文件行内容全部存入String数组列表中
def array = new File(basePath, '.gitignore') as String[]

// 把读到的文件内容全部转存为byte数组
byte[] contents = new File(basePath, '.gitignore').bytes

// 把读到的文件以InputStream闭包操作，此方式不需要手动关闭流
new File(basePath, '.gitignore').withInputStream {
    stream -> lists = stream.readLines()
}

/**
 * 写文件操作
 */
// 向一个文件以utf-8编码写三行文字
new File(basePath, 'demo.txt').withWriter('utf-8') {
    writer ->
        writer.writeLine 'Into the ancient pond'
        writer.writeLine 'A frog jumps'
        writer.writeLine 'Water’s sound!'
}

// 另一种书写方式
new File(basePath, 'demo.txt') << '''Into the ancient pond
A frog jumps
Waters's sound'''

// 使用OutputStream闭包进行输出流操作
new File(basePath, 'demo.txt').withOutputStream {
    stream -> stream.write(123)
}

// 文件数操作
// 遍历所有指定路径下的文件名打印
def dir = new File(basePath)
dir.eachFile { file -> println file.name }
// 遍历所有指定路径下
dir.eachFileMatch(~/.*\.txt/) {
    file -> println(file.name)
}
// 深度遍历打印名字
dir.eachFileRecurse { file -> println(file.name) }
// 深度遍历打印名字，只包含文件类型
dir.eachFileRecurse(FileType.FILES) { file -> println(file.name) }
// 允许设置特殊标记规则的遍历操作
dir.traverse { file ->
    if (file.directory && file.name == 'src') {
        FileVisitResult.TERMINATE
    } else {
        println(file.name)
        FileVisitResult.CONTINUE
    }
}

// 执行外部程序
//def process = "dir".execute()
//println "Found  text ${process.text}"

/* --------------------有用的工具类操作-------------------- */
// ConfigSlurper配置
def config = new ConfigSlurper().parse('''
    app.date = new Date()
    app.age  = 42
''')

assert config.app.date instanceof Date
assert config.app.age == 42

// Expando扩展
def expando = new Expando()
expando.toString = { -> 'John' }
expando.say = { String s -> "John says: ${s}" }

assert expando as String == 'John'
assert expando.say('Hi') == 'John says: Hi'
