//1. var/val
/* var = variable = 읽기/쓰기가 가능한 일반 변수
val = valuable = 읽기만 가능한 변수
코틀린은 자바와 달리 ;을 쓰지 않는다 */
fun main() {
    println("Hello Kotiln!")
}

//fun main(args: Array<String>) {
//    var name:String = "name"
//    println("name = $name")
//    name = "kotiln"
//    println("name = $name")
//}

//2. NULL/NULLABLE
/* Non-null : null을 값으로 갖지 못함
* Nullable : null을 값으로 가질 수 있음
*/
//var name: String = null //error; if you assign null to a varaible Non-null type

/*코틀린에서는 null 값을 가질 수 있는 Nullable 타입이 되려면 타입 끝에 물음표(?)를 선언해야 한다.
Nullable 타입은 null 외 값도 가질 수 있기 때문에 Non-null타입을 할당 할 수 있다.
var/val 변수명:변수 타입?= 초기화
*/
/*fun main(args: Array<String>) {
    var name: String? = null
    var firstName: String? = null
    var lastName: String = "seo"
    firstName = lastName;

}*/
//but) 당연히 반대의 경우는 불가하다. : Non-null 타입에 null 값을 가진 변수가 할당될 가능성이 있기 때문이다.
/* var firstName: String? =null
*  var lastName: String = "Seo"
* lastName = firstName; //Error : Type mismatch
*/
//3-1. Safe call: 안전호출
//기본형태는 다음과 같다
//Nullable 변수 ?. 참조할 속성 또는 호출할 메서드
//안전 호출 연산자는 유의미하지는 않지만 Non-null 타입에도 사용할 수 있다. 하지만 Nullable 타입은 선택이 아닌 필수로 사용해야 한다.
//fun main(args: Array<String>) {
//    var firstName: String? = "Junsu"
//    var lastName: String = "Seo"
////    print("${firstName?.length}"+","+"${lastName.length}") 다음과 같이 lastName에 안전 호출 연산자를 사용해도 상관없다
//    print("${firstName?.length}"+","+"${lastName?.length}")
//}

//유의미하지않은데 안전 호출 연산자는 왜 사용할까? 안전 호출 연산자의 역활은 null 여부를 판별해 null이 아니면 속성을 참조하거나 메서드를 호출한다.(null이면 null을 리턴한다.)
//fun main(args: Array<String>) {
//    var firstName: String? =null
//    var lastName: String = "Seo"
//    print("${firstName?.length}"+","+"${lastName?.length}")
//}

//Nullabel 타입이 null 값을 가지면 안전 호출 연산자 사용시 null을 리턴하기 때문에 null에 대한 비교를 못하는 것이 가능하게 한다.
/*
fun main(args: Array<String>) {
    var name:String? = null
    println("name = $name " + name.equals("Seo"))

}*/

////안전 호출 연산자의 사용
//fun main(args: Array<String>) {
//    var name:String? = null
//    println("name = $name" + name?.equals("Seo"))
//}
//안전 호출 연산자를 사용해 null을 리턴받을 경우, 사용할 값을 지정하는 방법이 있다.
//코틀린은 nullable타입 값이 null이면 null을 리턴하는 안전 호출 연산자를 사용할 때 null 대신 사용할 값을 지정할 수 있는 엘비스 연산자 ?: 를 제공한다.
//엘비스 연산자는 좌항이 null이 아니면 좌항을 값으로 갖고 null이면 우항을 값으로 가진다.
/*
fun main(args: Array<String>) {
    var first:String? = null
    var second:Boolean? = first?.equals("A") ?: getDefaultSecond()
    println("first = $first "+ "second = $second")
}
 */
//fun getDefaultSecond() = false

//3-2. 함수
//3-2-1. 멤버 함수는 클래스 안에 정의된 함수이다.
/*
fun main(args: Array<String>) {
    Date().getDate()
}

class Date() {
    fun getDate() {
        println("2019/01/30")
    }
}
//결과값 2019/01/30
 */

//3-2-2. 확장 함수 : 코틀린은 클래스 상속이나 데코레이터 패턴과 같은 디자인 패텅능ㄹ 사용하지 않고도 새로운 기능이 있는 클래스로 확장할 수 있다. 클래스에 새로운 기능을 추가할 때 확장 함수를 사용할 수 있다.
//확장 함수는 멤버 함수 처럼 사용할 수 있지만 클래스 내부가 아닌 외부에 선언한다.

//확장 함수의 기본형태: 이 형태에서 함수명 앞에 '확장하려는 대상'을 추가해주면 확장 함수가 된다.
/*
fun 확장하려는 대상.함수명(매개변수): Unit{
}
또는
fun 확장하려는 대상.함수명(매개변수): 리턴타입 {
return 값
}
 */
/*
fun main(args: Array<String>) {
    val a = "Apple"
    val b = "Banana"
    print(a.getLonggerLength(b))
}
fun String.getLonggerLength(x:String): String{
    return if (this.length > x.length){
        this
    } else  {
        x
    }
}
 */
//this는 수신자객체라고 한다(receiver object), 수신자인 string 타입 a를 가리킴

//string 외에도 int,double, byte와 같은 number를 비롯해 boolean, array까지 다양한 확자잉 가능하다.
/*
fun main(args: Array<String>) {
    val car = Car()
    println(car.getPrice())
}

class Car {
    fun getPrice() : Int{
        return 10000
    }
}

fun Car.getColor() : String {
    return "RED"
}
 */

//3-3-1. 클라스~~
/*
-class 선언
class 클래스명 constructor(매개변수) {}
또는
clss 클래스명(매개변수) {}
-생성자(constructor)가 클래스 명 뒤에 따라오는 것이 자바와 다르다. 또한 생성자 키워드도 생략 가능하다.
 class 클래스명{
 생성자(매개변수){
 }
 }
 */

//3-3-2. 프로퍼티
//코틀린은 프로퍼티를 기본적으로 제공한다. 자바의 멤버 변수와 같지만 프로퍼티는 static 변수를 포함하지 않기 때문에 멤버 변수라고 하지는 않는다.
/*class Person{
    var id: Int = 0
    var name: String = "Junsu"
}
//프로퍼티를 위와 같이 만든 후 필드처럼 변수명으로 쉽게 부를 수 있다.
    val student = Person() //new 키워드를 사용하지 않음
    student.id = 10
    student.name = "kim"

 */

//static 변수를 사용해야 할 경우에는 companion object를 사용하면 된다.
/*
fun main(args: Array<String>) {
    val student = Person()
    student.id = 10
    student.name = "kim"
    Person.age = 20

    println("student.id = ${student.id}")
    println("student.name = ${student.name}")
    println("Person.age = ${Person.age}")
}

class Person{
    var id: Int = 0
    var name: String = "Junsu"
    companion object{
        var age: Int = 0
    }
}

 */

//3-3-3. 생성자
//자바처럼 코틀린도 기본 생성자(primary constructor) 외에 보조 생성자를 지원한다.
/*
fun main(args: Array<String>) {
    var car = Car()
    println(car.getColor())
}
//클래스명 바로 뒤에 오는 생성자가 기본 생성자 이다.
class Car constructor(val carPrice: Int = 1000, val carColor: String = "RED"){
    fun getPrice(): Int{
        return carPrice
    }
}

fun Car.getColor(): String{
    return carColor
}

 */

//생성자의 추가 : 코틀린 코드에서 고칠 내용은 Car객체를 생성하는 부분뿐이다.
/*
fun main(args: Array<String>) {
    var car = Car(20000,"Blue")
    println(car.getColor())
}

class Car constructor(val carPrice: Int = 1000, val carColor: String = "RED"){
    fun getPrice(): Int{
        return carPrice
    }
}

fun Car.getColor(): String{
    return carColor
}

 */

//다양한 매개변수의 처리 : 매개변수명의 활용
/*
fun main(args: Array<String>) {
    var car = Car(carPrice = 5000, carColor ="BLUE")
    println(car.getPrice()) //5000, BLUE
    println(car.getColor())
}

class Car constructor(val carPrice: Int=10000, var carColor: String = "RED"){
    fun getPrice() : Int{
        return carPrice
    }
}

fun Car.getColor() : String {
    return carColor
}

 */

//Getter와 Setter
//프로퍼티 선언할 때 생략 없는 완전한 문법
/*
var <propertyName>[: <PropertyType] [= <property_initializer>]
[<getter>]
[<setter>]
*/
//이제까지 썼던 예제들은 initializer은 사용했지만 getter와 setter은 사용하지 않았다.
//initializer를 단순 생략하면 에러가 나므로 다음과 같은 방법들을 사용하여 생략하도록 하자
//1)추상화
/*
fun main(args: Array<String>) {
    abstract class Person{
    abstract var id: Int
        var name: String = "Junsu"
    }
}
//추상화를 한 뒤 프로퍼티를 생성자로 옮긴다
class Person(var id: Int){
    var name: String = "Junsu"
}

 */

//2) 프로퍼티에 바로 접근
/*
fun main(args: Array<String>) {
    var p = Person(100)
    print(p.name)
}
class Person(var id: Int){
    var name: String = "Junsu"
}

 */

//getter을 선언하는 법
/*
fun main(args: Array<String>) {
    var p = Person()
    p.age = 50
    println(p.age)
}

class Person(){
    var age: Int = 20
        get() = 30
    var name: String = "Seo"
        get() = "Kim"
}
//age변수에 50을 할당하고 있지만 getAge()에서 고정된 30이라는 값을 리턴하기 때문에 출력되는 값이 30이 되는 것을 알 수 있다.

 */
//setter
//50을 가져오기위해서는 field식별자를 사용해 Get()=filed라고 해야된다.
//field사용한 식별자값 고정

/*
fun main(args: Array<String>) {

    var p = Person()
    p.age = 50
    println(p.age)
}

class Person(){
    var age: Int = 20
        set(value) {
            field = 200
        }
}
 */

//setter 완성
/*
fun main(args: Array<String>) {

    var p = Person()
    p.age = 50
    println(p.age)
}

class Person(){
    var age: Int = 20
        set(value) {
            field = value
        }
}
 */

//3-3-5. 초기화 블록(initializer blocks) : 코틀린의 기본 생성자는 별도 코드를 포함할 수 없지만 초기화 블록을 이용해 초기화 코드를 작성할 수 있다.
//초기화 블록은 init 키워드를 통해 사용할 수 있다.
/*
fun main(args: Array<String>) {
    val car = Car()
    println(car.getColor())
}

class Car constructor(var carPrice: Int, var carColor: String){ //기본 생성자의 매개변수를 var 타입으로 변경해주어야 한다. val 타입은 재할당이 불가능한데 초기화 블록에서는 매개변수값을 재할당하고 있기 때문에
    constructor(): this(0,"")
    fun getPrice(): Int {
        return carPrice
    }
init {
        carPrice = 10000
        carColor = "RED"
    }
}
fun Car.getColor() : String{
    return carColor
}
 */

//초기화 블록과 생성자 호출 순서
/*
fun main(args: Array<String>) {
    val car = Car()
    println(car.getColor())
}

class Car constructor(var carPrice: Int, var carColor: String){ //기본 생성자의 매개변수를 var 타입으로 변경해주어야 한다. val 타입은 재할당이 불가능한데 초기화 블록에서는 매개변수값을 재할당하고 있기 때문에
    constructor(): this(0,""){
        println("secondary constructor :: carPrice = $carPrice, carColor = $carColor")
    }
    fun getPrice(): Int {
        return carPrice
    }
    init {
        carPrice = 10000
        carColor = "RED"
        println("init block :: carPrice = $carPrice, carColor = $carColor")
    }
}
fun Car.getColor() : String{
    return carColor
}

 */

//3-3-6. let, lateinit, lazy를 이용한 초기화
//let은 Nullable 타입을 다루는 데 용이하다. 안전 호출 연산자를 사용해 null여부를 확인하고 null이 아닐때 그 값을 사용하도록 할 수 있다.
//보통의 null체크 : address 변수가 null이 아니면 let을 호출해 address를 출력하는 코드
/*
var address: String? = null
if (address != null){
    println(address)
}
 */
//let을 사용한 null체크
/*
var address: String? = null
address?.let{
    println(address)
}
 */

//let은 수신자 객체를 자신의 인자인 람다에 전달한다. 따라서 람다의 매개변수가 하나뿐이고 컴파일러가 타입을 추론할 수 있을 때 사용되는 디폴트 매개변수명인 it을 사용할 수 있다.
//name과 address가 null이 아니면 let의 수신자 객체인 it을 출력하도록 한다. it은 각 수신자 객체인 name과 address이다
/*
fun main(args: Array<String>) {
    val name: String? = "Son"
    name?.let{
        println(it)
    }
    val address: String? = null
    address?.let{
        println(it)
    }
}
 */

//lateinit은 프로퍼티를 나중에 초기화할 수 있도록 해준다.
//Non-null타입은 다음과 같이 초기화하지 않으면 에러가 발생한다.
/*
class MyAddress{
    private var adress: String //error
}
 */
//초기화 시점에 어떤 값으로 할지, 초기화할지 정하지 못한다면 Nullable 타입을 사용할 수밖에 없다. 일단 null로 초기화할 수 있기 때문이다. 하지만 그경우, null 체크해야 하는 번거로움이 생긴다.
/*
fun main(args: Array<String>) {
    val myName = MyName()
    myName.printNameLength()
    myName.setName()
    myName.printNameLength()
}

class MyName {
    var name: String? = null
    fun printNameLength(){
        println("Name=${name?.length}")
    }
    fun setName(){
        name = "Son"
    }
}
//앞의 예제를 보면 Nullable 타입인 name을 null로 초기화 했다. 이 경우 null 체크가 필요하기 때문에 printNameLength()에서 안전 호출 연산자를 사용하고 있다. 그 후 벼수 name이 var 타입이므로 실제로 원하는 값으로 초기화할때 setName()을 통해 초기화(재할당)할 수 잇다.
 */

//lateinit사용예제: name과 address의 문자열 출력하기
/*
fun main(args: Array<String>) {
    val myName = MyName()
    myName.initName()
    myName.printName()

    val myAddress = MyAddress()
    myAddress.initAddress()
    myAddress.printAddress()
}

class MyName {
    private var name: String? = null
    fun initName(){
        name="Son"
    }
    fun printName(){
        println("Name=$name")
    }
}

class MyAddress {
    private lateinit var address: String
    fun initAddress() {
        address = "Seoul"
    }
    fun printAddress() {
        println("Address=$address")
    }
}
 */
//lateinit의 사용조건
/*
1. var 타입
2.non-null 타입
3.변수를 초기화 하지 않고 사용할 수 없음
4.setter/getter정의 불가 
5.primitive 타입 변수에 사용불가
 */

//lazy는 by lazy() 형태의 위임 프로퍼티로 사용한다. lazy 객체를 초기화 안한 채 있다가 실제로 값이 필요할 때 초기화한다. 따라서 객체 사용 시 매번 초기화할 필요가 없거나 초기화 대 무거운 동작을 하는 경우에 유용하다.
//초기화시 무거운 동작을 하는 예제
/*
fun main(args: Array<String>) {
    val name = Name()
    val allName = name.loadNameList()
}
class Name{
    fun loadNameList(): List<String> {
        println("Loading 10000 data...")
        return listOf("A","B","C","...")
    }
}
*/

//3-3-8. 상속과 추상 클래스 및 인터페이스
//코틀린에서도 코드 재사용성을 높여주는 객체지향의 주요 개념인 상속을 지원한다. 코틀린에서는 부모 클래스를 선언하지 않은 클래스는 default super로 Any라는 부모 클래스를 갖는다.
//코틀린 클래스 계층의 루트이며 모든 코틀린 클래스는 부모 클래스로 any를 갖는다고 한다.
//any는 object와 달리 equals(), hashCode(), toString()외 다른 멤버를 갖지 않는다. Object는 clone(), notify() 등 다른 멤버가 있다.
//상속을 위해서는 부모 클래스에 open 키워드를 명시적으로 선언해야 한다. 자식 클래스는 클래스 선언 시 상속받으려는 부모 클래스를 클론(:)뒤에 명시해야 한다.
/*
//open 키워드 사용 예제
open class Person
class Student(subAge: Int) : Person(subAge)
 */

//추상클래스
/*
abstract class Student{
    abstract fun learnKotlin() //최소 하나 이상의 멤버가 abstract
    fun learnJava() {}
}
 */

//abstract 멤버 함수로 재정의
/*
open class Person {
    open fun needToSleep() {}
}
abstract class Student : Person() {
    override abstract fun needToSleep() {
        abstract fun learnKotlin()
        fun learnJava() {}
    }
}

 */

//추상 클래스와 함께 짝처럼 다니는 것이 인터페이스이다. 코틀린도 인터페이스가 있으면 클래스 안에 abstract 멤버 함수뿐만 아니라 일반 멤버 함수 구현도 가능핟.
//abstract 함수가 아닌 함수 재정의
/*
interface Person{
    fun needToSleep()
    fun getName():String = "Hong"
}
class Student : Person{
    override fun needToSleep() {
    }
    override fun getName(): String {
        return "Tom"
    }
    fun learnKotlin(){
    }
}

 */

//추상클래스와 인터페이스의 큰 차이점 중 하나는 추상 클래스 상속은 단 하나만 가능하지만 인터페이스는 중복 상속이 가능하다.

//3-4-1. IF, WHEN 문
/*
//예제1
fun main(args: Array<String>) {
    println(getBiggerNumber(1,10))
}
fun getBiggerNumber(a: Int, b: Int) : Int{
    var bigger = a
    if (a < b) bigger = b
    return bigger
}
*/

/*
//예제2
fun main(args: Array<String>) {
    println(getBiggerNumber(1,10))
}
fun getBiggerNumber(a: Int, b: Int) : Int{
    return if (a<b) b else a
}
*/

/*
//when 예제
fun main(args: Array<String>) {
    val a = 3

    when (a){
        1 -> println("a = 1")
        2 -> println("a = 2")
        else -> println("a is neither 1 nor 2")
    }
}
*/

//3-4-2. for, while 문
/*
//in 연산자를 사용하여 for문에서 특정 객체 포함 확인하기
fun main(args: Array<String>) {
    val alphabet = "ABCDEFGHIJK"
    for (i in alphabet) print("$i, ")
}
*/
//배열 값 바로 가져오기
/*
fun main(args: Array<String>) {
    val x: IntArray = intArrayOf(10, 20, 30)
    for (a in x){
        println("value = $a")
    }
}
*/
//배열의 인덱스값 가져오기
/*
fun main(args: Array<String>) {
    val x: IntArray = intArrayOf(10, 20, 30)
    for (a in x.indices){
        println("value = $a")
    }
}*/

//배열의 인덱스와 값을 동시에 가져오기
/*
fun main(args: Array<String>) {
    val x: IntArray = intArrayOf(10, 20, 30)
    for ((index, value) in x.withIndex()){
        println("the element at $index is $value")
    }
}*/
//for문 증감 연산
/*
fun main(args: Array<String>) {
    for(i in 0..10 step 2)
        println("i = $i")
}*/
