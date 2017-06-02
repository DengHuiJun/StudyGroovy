/**
 * 读取Excel
 * Created by zero on 17-4-24.
 */

def jdbc = '''
jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
DBQ = /home/zero/groovy.xlsx;
READONLY = false
'''

def sql = groovy.sql.Sql.newInstance(jdbc, '', '')

println "name\t\tage"

def query = 'SELECT * FROM [workers$]'

sql.eachRow(query) {
    println "${it.name}\t\t${it.age}"
}