# Automation Java Portfolio

Proyecto base de automatización web para portfolio. Automatiza el login de [SauceDemo](https://www.saucedemo.com/) con Java, Selenium, Cucumber y Allure.

## Stack

- Java 25
- Maven
- Selenium WebDriver
- Cucumber (Gherkin en español)
- JUnit Platform
- Allure Report

## Requisitos

1. Instalar un JDK 25 o superior y comprobarlo con `java -version`.
2. Instalar Maven y comprobarlo con `mvn -version`.
3. Tener Google Chrome, Microsoft Edge o Firefox instalado.

Selenium Manager resuelve automáticamente el driver del navegador; no hace falta descargar un `chromedriver` manualmente.

## Ejecutar pruebas

Desde la raíz del proyecto:

```powershell
mvn clean test
```

Por defecto se ejecuta con Chrome. Para otro navegador:

```powershell
mvn clean test -Dbrowser=edge
mvn clean test -Dbrowser=firefox
```

Para ejecutar solo los escenarios smoke:

```powershell
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Ver reportes

Al finalizar las pruebas, Allure guarda los resultados en `target/allure-results`.

```powershell
mvn allure:serve
```

El reporte temporal se abrirá en el navegador. Si preferís conservarlo:

```powershell
mvn allure:report
```

## Estructura y responsabilidades

- `pages`: Page Objects; contienen locators y acciones de cada pantalla.
- `steps`: conexión entre los escenarios Gherkin y los Page Objects.
- `hooks`: inicia/cierra el navegador y adjunta screenshot a Allure si falla un escenario.
- `driver`: administra una instancia del navegador por escenario.
- `features`: escenarios BDD escritos en español.

## Próximas mejoras para el portfolio

1. Crear `InventoryPage` y `CartPage` para agregar y quitar productos.
2. Automatizar checkout válido y validaciones de campos obligatorios.
3. Crear datos de prueba reutilizables y escenarios outline.
4. Agregar ejecución en GitHub Actions.
5. Configurar ejecución paralela y perfiles por ambiente.

## Nota

El `groupId` y el paquete `com.tuusuario` son intencionalmente personales: reemplazalos por tu usuario de GitHub, por ejemplo `com.maria.garcia.automation`.
