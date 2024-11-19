# Priemtester

Dit is het project bij de Java/Spring-Boot variant van de tutorial ['Unit testing C# in .NET using dotnet test and xUnit'](<https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-with-dotnet-test>) op Microsoft Learn (2024). De tutorial bij deze code staat in de vorm van een blog op de website van de minor DevOps van de HAN (van der Wal, 2024). Deze tutorial toont een project opzet met enkele projecten:

- Doen priemgetal checks vanaf command line (console package)
- Kern priemcheck functionaliteit (service package)
- JUnit test-project voor service package (unit test package)

## How to run?

Zoals elke goede README.md starten we met een 'How to run'. Zoals o.a. Microsoft aanraadt (Microsoft Learn, 2022). Zorg dat je **Maven** geïnstalleerd hebt. Maven is een populaire build tool voor Java-projecten. Je kunt Maven installeren via de officiële instructies [hier](https://maven.apache.org/install.html).

Run dan deze Spring Boot (web) applicatie met:

```console
mvn spring-boot:run
```

Voor (simpelere) lint check doe
```console
mvn checkstyle:check
```

Om alle tests uit te voeren, gebruik de standaard (old skool Sun Checkstyle (v9.3)):
```console
mvn test
```

Om alleen unit tests uit te voeren:
```console
mvn test -Punit-tests
```

Om alleen integratietests uit te voeren:
```console
mvn verify -Pintegration-tests
```



NB: Deze opzet is afhankelijk van het strikt volgen van  naamgevingsconventies (`*UnitTest.java` voor unit tests en `*IntegrationTest.java` voor integratietests) om onderscheid te maken tussen de twee soorten tests. Bij uitbreiden van het project wil je wellicht dit aanpassen. Of de postfix `AcceptanceTest` gebruiken voor de integratietests, e.d.

## Code

Hier meer technische details over de code en structuur.

Dit project bestaat uit:

- unit test-project
- en een broncode-project bevat.

Er zijn twee implementaties, een eigen 'custom' en eentje die een Maven package gebruikt uit `commons-numbers-primes` package. Zie JavaDoc in [common-numbers-primes](https://commons.apache.org/proper/commons-numbers/commons-numbers-primes/javadocs/api-1.2/org/apache/commons/numbers/primes/Primes.html).

Deze ondersteunen beiden 'enkel' normale integers. Voor grotere getallen kunnen/moeten we `BigInteger`s priemfunctie gebruiken (apache.org, z.d.).

## Extra: Front-end en pipeline

In de `gh-actions` branch zit een versie met een pipeline en front-end.
Deze converteren we naar een React front-end met een storybook test.

## Extra: ORM & BDD Opdracht

In de `orm-bdd` branch van dit project komt een variant die ook nog RESTful services aanbiedt via Spring Boot. Gebruik dit project of ga verder in je eigen Java 'prime project' uit weekopdracht 1 en/of weekopdracht en zorg dat je:

## Bronnen

- Microsoft Learn (3-7-2024). *Unit testing with dotnet test.* Geraadpleegd november 2024 op <https://learn.microsoft.com/en-us/dotnet/core/testing/unit-testing-with-dotnet-test>
- Microsoft Learn (10-4-2022). *Create a README*. Geraadpleegd november 2024 op https://learn.microsoft.com/en-us/azure/devops/repos/git/create-a-readme
- https://stackoverflow.com/questions/1801003/java-biginteger-prime-numbers
- https://commons.apache.org/proper/commons-numbers/commons-numbers-primes/javadocs/api-1.2/org/apache/commons/numbers/primes/Primes.html
