# msasr-d-serv-delivery-management

Administración de las entregas  diarias de empleados de la empresa rinku

# Version

![version](https://img.shields.io/badge/version-1.0.0-blue.svg)

Para más detalle mira el archivo [CHANGELOG](CHANGELOG)

# Code Analize

[![SonarCloud](https://github.com/felipemonzon/msasr-d-serv-payroll-management/actions/workflows/sonarCloud.yml/badge.svg?branch=main)](https://github.com/felipemonzon/msasr-d-serv-payroll-management/actions/workflows/sonarCloud.yml)

### Pre-requisitos 📋

Tener instalado
* Eclipse o tu IDE favorito
* Maven
* Java 1.8
* Lombok
* PostgreSql

### Instalación 🔧

Proyecto generado y compilado con maven

```
mavn clean install
```

## Ejecutando las pruebas ⚙

Para ejecutar las pruebas y comprobar la calidad del código en sonar

```
mvn clean install site sonar:sonar -Psonar
```

### Y las pruebas unitarias de codificación ⌨️

Las pruebas se realizaron con mockito y junit



      @Test
      public void metodoTest() {
        Mockito.when(mock).thenReturn(resultadoEsperado);
        Assert.assertNotNull(metodoa probar);
      }



## Despliegue 📦

## Construido con 🛠️

* Spring boot 2.4.0
* Spring Cloud
* Java 1.8
* Maven
* Intellij IDEA

### Generación de Reportes 📋

Brindan un panorama general de varios reportes que son generados automáticamente por Maven.


Los reportes se generan en la carpeta target > site > index.html

## Versionado 📌

Usamos [GitHub](https://github.com/felipemonzon/msacm-d-csmg-customer-managment) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/felipemonzon/msacm-d-csmg-customer-managment/tags).
## Autores ✒️

* **[Felipe Monzón](https://felipemonzon.github.io/)** - *WEB AND JAVA DEVELOPER*

## Contribuyendo 🖇


## Licencia 📄

Este proyecto está bajo la Licencia MIT License - mira el archivo [LICENSE.md](LICENSE) para detalles

