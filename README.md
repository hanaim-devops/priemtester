# Priemtester

Dit is het project bij de Java/Spring-Boot variant van de tutorial ['Unit testing C# in .NET using dotnet test and xUnit'](<https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-with-dotnet-test>) op Microsoft Learn (2024). De tutorial bij deze code staat in de vorm van een blog op de website van de minor DevOps van de HAN (van der Wal, 2024). Deze tutorial toont een project opzet met enkele projecten:

- Doen priemgetal checks vanaf command line (console package)
- Kern priemcheck functionaliteit (service package)
- JUnit test-project voor service package (unit test package)

# Extra: ORM & BDD Opdracht

In de `orm-bdd` branch van dit project zit of komt een variant die ook nog RESTful services aanbiedt via Spring Boot. Gebruik dit project of ga verder in je eigen Java 'prime project' uit weekopdracht 1 en/of weekopdracht en zorg dat je:

- unit test-project
- en een broncode-project bevat.

## Bronnen

De .NET-variant stond/staat op Microsoft Learn (3-7-2024): <https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-with-dotnet-test>
Er zijn twee implementaties, een eigen 'custom' en eentje die een Maven package gebruikt uit `commons-numbers-primes` package. Zie JavaDoc:
https://commons.apache.org/proper/commons-numbers/commons-numbers-primes/javadocs/api-1.2/org/apache/commons/numbers/primes/Primes.html

Deze ondersteunen beiden 'enkel' normale integers. Voor grotere getallen moeten we BigInteger gebruiken:
- https://stackoverflow.com/questions/1801003/java-biginteger-prime-numbers
- https://commons.apache.org/proper/commons-numbers/commons-numbers-primes/javadocs/api-1.2/org/apache/commons/numbers/primes/Primes.html