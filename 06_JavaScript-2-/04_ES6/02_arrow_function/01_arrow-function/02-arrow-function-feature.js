

let theater = {
    store : "건대점",
    titles : ["어벤져스", "겨울왕국", "스파이더맨", "라이온킹", "알라딘"],

    // 1. 화살표 함수는 this를 가지지 않는다.
    showMoiveList() {
        this.titles.forEach(
            title => console.log(`${this.store} : ${title}`)
        ); // 외부에서 this를 찾음

        // 화살표 함수가 아닌 일반 함수 안에서의 this는 Global이라고 하는 전역 객체를 가리킴
        this.titles.forEach(function(title) {
            console.log(`${this.store} : ${title}`);
        })
    }
}

theater.showMoiveList();

// this가 없기 때문에 생성자 함수로 사용할 수 없다.
const arrowFunc = () => {};
// new arrowFunc(); // TypeError: arrowFunc is not a constructor
// 화살표 함수는 인스턴스를 생성할 수 없으므로 prototype 프로퍼티가 없고 프로토타입도 생성하지 않는다.
console.log(arrowFunc.hasOwnProperty('prototype'));

// 화살표 함수는 super를 가지지 않는다.
class Animal {

    constructor(name, weight) {
        this.name = name;
        this.weight = weight;       
    }

    move(loseWeight) {
        if(this.weight > loseWeight)
            this.weight -= loseWeight;
        console.log(`${this.name}(은)는 움직임으로 인해 ${loseWeight}kg 감량되어 ${this.weight}kg이 되었습니다.`);
    }
}

class Tiger extends Animal {

    move(loseWeight) {

        /* 화살표 함수 */
        setTimeout(() => super.move(loseWeight), 2000); //super를 외부에서 찾아 사용할 수 있음 (=this)
        
        /* 일반 함수 */
        // setTimeout(function() {
        //     super.move(loseWeight)}, 1000) //일반 함수는 자기 자신의 this를 가지고 있기 때문에 super 키워드를 사용할 수 없음
        console.log('먹이를 찾아 산기슭을 어슬렁');
    }
}

let tiger = new Tiger("백두산 호랭이", 90);
tiger.move(1);

// 화살표 함수는 arguments를 지원하지 않는다.
(function() {
    const arrowFunc = () => console.log(arguments);
    arrowFunc(3, 4);
}(1,2));