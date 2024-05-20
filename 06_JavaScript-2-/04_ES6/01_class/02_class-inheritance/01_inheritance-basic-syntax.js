
class Animal {

    constructor(name, weight) {
        this.name = name;
        this.weight = weight;       
    }

    eat(foodWeight) {
        this.weight += foodWeight;
        console.log(`${this.name}(은)는 ${foodWeight}kg의 식사를 하고 ${this.weight}kg이 되었습니다.`);
    }

    move(loseWeight) {
        if(this.weight > loseWeight)
            this.weight -= loseWeight;
        console.log(`${this.name}(은)는 움직임으로 인해 ${loseWeight}kg 감량되어 ${this.weight}kg이 되었습니다.`);
    }
}

let animal = new Animal("동물", 30);
animal.eat(1);
animal.move(0.5);

class Human extends Animal {

    develop(language) {
        console.log(`${this.name}(은)는 ${language}로 개발을 합니다.`)
    }
}

let human = new Human("수강생", 70);
human.eat(20);
human.move(1);

human.develop("JavaScript");