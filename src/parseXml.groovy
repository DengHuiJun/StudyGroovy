/**
 * Created by allen on 2017/6/1.
 */

def basePath = '/Users/Allen/'
def fileName = 'lint-results-debug.xml'

//new File(basePath, fileName).eachLine {
//    line -> println(line)
//}

List<String> paths = new ArrayList<>();
def list = new XmlSlurper().parse(new File(basePath + fileName))

list.'**'.findAll {
    node ->
        if (node.name() == 'issue' && node.@id == 'UnusedResources') {
           paths.add(node.location.@file)
        }
}

for (i in 0 .. paths.size()-1) {
    println paths.get(i)
}