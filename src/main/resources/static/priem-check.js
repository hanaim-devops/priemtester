console.log("Hallo allemaal in ello primo testero!");
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('checkButton').addEventListener('click', function() {
        fetch('/priem')
            .then(response => response.text())
            .then(data => {
                document.getElementById('response').value = data;
            })
            .catch(error => {
                console.error('Error fetching data:', error);
                document.getElementById('response').innerText = 'Error loading data';
            });
        const number = document.getElementById('priemKandidaat').value;
        fetch(`/priem`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({number: number})
        })
            .then(response => response.json())
            .then(isPrime => {
                const priemResult = document.getElementById('priem-result');
                if (isPrime) {
                    priemResult.value = `${number} is een priemgetal`;
                } else {
                    priemResult.value = `${number} is GEEN priemgetal`;
                }
            })
            .catch(error => {
                const errorMessage = `Er is een fout opgetreden bij het checken van ${number}: ${error.message}`;
                document.getElementById('priem-result').innerText = errorMessage;
                console.error(errorMessage, error);
            })
    })
})