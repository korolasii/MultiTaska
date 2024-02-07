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
            } else if (buttonValue === '=') {
                submitForm()
            } else {
                inputField.value += buttonValue;
            }
        });
    });

    function submitForm() {

        var inputField = document.getElementById('displayAnswer');
        var expression = inputField.value;


        fetch('/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ expression: expression })
        })
            .then(response => response.json())
            .then(data => {
                inputField.value = data.result;
            })
            .catch(error => console.error('Error:', error));
    }


});