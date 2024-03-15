/* 프로토타입 접근 시 사용하는 모던 메소드 */

const user = {
    activate : true
};

// Object.create(proto) : [[Prototye]]이 proto를 참조하는 빈 객체 생성
const student = Object.create(user);    
console.log(student.activate);

// Object.getPrototypeOf(obj) : obj의 [[Prototype]]을 반환
console.log(Object.getPrototypeOf(student) === user);

// Object.setPrototypeOf(obj, proto) : obj의 [[Prototype]]을 proto로 설정
Object.setPrototypeOf(student, {});     // student의 프로토타입을 {}으로 변경
console.log(Object.getPrototypeOf(student) === user);