// ECMA 2016-2018
const user = {
	name: "Tom",
	age: 42,
};

/*
const name = user.name;
const age = user.age;
*/

const { name, age } = user;
console.log(name);
console.log(age);





/*
const n = 42;

const result = (function(){
	if (n % 2 == 0) {
		return "짝"
	} else {
		return "홀"
	}
})();

console.log(result);
*/

/*
let result;
if (n % 2 == 0) {
	result = "짝";
} else {
	result = "홀";
}
*/
