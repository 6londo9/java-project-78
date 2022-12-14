### Hexlet tests and linter status:
[![Actions Status](https://github.com/6londo9/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/6londo9/java-project-78/actions)
<a href="https://codeclimate.com/github/6londo9/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/b8b5493b1386a2d74dac/maintainability" /></a>
<a href="https://codeclimate.com/github/6londo9/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/b8b5493b1386a2d74dac/test_coverage" /></a>
___
### Data Validator
#### This is a validator, that can check if String, Integer or Map is Valid.
#### You can initialize it by typing:
```
Validator v = new Validator;
```
___
#### To validate String you need to call:
```
v.string();

v.isValid(null); // true
v.isValid(2); // false
v.isValid("true"); // true

v.required(); // now the Strings will be valid only if they are String types
v.isValid(null); // false

v.minLength(3); // The String should have length 3 or more
v.isValid("no"); // false
v,isValid("yes"); // true

v.contains("be").isValid("to be or not to be"); // check if given String is in isValid String
v.contains("be").isValid("to be or not to be"); // true
v.contains("ornot").isValid("to be or not to be"); // false
```
___
#### To validate Integer:
```
v.number();

v.isValid(null); // true
v.isValid("0"); // false
v.isValid(0); // true