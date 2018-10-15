const n = 42;

const result = (function(){
	if (n % 2 == 0) {
		return "짝"
	} else {
		return "홀"
	}
})();

console.log(result);

/*
let result;
if (n % 2 == 0) {
	result = "짝";
} else {
	result = "홀";
}
*/
