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
    function submitForm(event) {
        event.preventDefault();


        var inputValue = inputField.value;


        fetch('/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                inputValue: inputValue,
            }),
        })
            .then(response => response.json())
            .then(data => {

                inputField.value = data.returnedValue;
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

});
