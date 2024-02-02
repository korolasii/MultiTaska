document.addEventListener("DOMContentLoaded", function () {

    var buttons = document.querySelectorAll('.btn');


    var inputField = document.querySelector('.displayAnswer');


    buttons.forEach(function (button) {
        button.addEventListener('click', function () {

            var buttonValue = button.innerText;


            if (buttonValue === 'C') {

                inputField.value = '';
            } else if (buttonValue === '←') {

                inputField.value = inputField.value.slice(0, -1);
            } else {

                inputField.value += buttonValue;
            }
        });
    });
});