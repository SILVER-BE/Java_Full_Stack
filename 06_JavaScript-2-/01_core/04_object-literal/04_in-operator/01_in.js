/* in 연산자 */
// 프로퍼티 존재 여부 확인

var actor = {
    name : '마동석',
    age : 53,
    gender : 'M',
    company : undefined
};

console.log(actor.name === undefined);      //false - 존재
console.log(actor.age === undefined);       //false - 존재
console.log(actor.drama === undefined);     //true - 존재하지 않음
console.log(actor.company === undefined);   //true - 존재하지만 프로퍼티 값이 undefined --> 문제!

// in 연산자 사용
console.log("name" in actor)            //true
console.log("age" in actor)             //true
console.log("drama" in actor)           //false
console.log("company" in actor)         //true