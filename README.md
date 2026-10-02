# Лаб 04: JUnit 5 нэгжийн тест

**Оюутан:** [А.Адъяахүү]
**Код:** [B232270125]

## Орчин

```
java version "22.0.2" 2024-07-16
Java(TM) SE Runtime Environment (build 22.0.2+9-70)
Java HotSpot(TM) 64-Bit Server VM (build 22.0.2+9-70, mixed mode, sharing)
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: C:\Users\HiTech\Downloads\apache-maven-3.9.9-bin\apache-maven-3.9.9
Java version: 22.0.2, vendor: Oracle Corporation, runtime: D:\jdk
Default locale: en_US, platform encoding: UTF-8
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

Лабыг Windows 11 дээр PowerShell ашиглан гүйцэтгэсэн.

## Тестийн тоо

- Тестийн метод: **13** (11 `@Test`, 2 `@ParameterizedTest`)
- `results/mvn-test.txt` дахь `Tests run`: **22** (Failures: 0, Errors: 0, Skipped: 0), `BUILD SUCCESS`
- 22 = 11 энгийн тест + 8 мөр (`letterGradeBoundaries`) + 3 мөр (`totalScoreParameterized`).

## Мутацийн туршилт

`letterGrade` доторх `score >= 90`-ийг `score > 90` болгож `mvn test` ажиллуулсан (`results/mvn-test-mutant.txt`).

- Үр дүн: `Tests run: 22, Failures: 2`, `BUILD FAILURE`
- Унасан тестүүд: `ninetyIsExactlyA`, `letterGradeBoundaries[2]` (`90,A` мөр). Хоёуланд нь `expected: <A> but was: <B>`.
- Дараа нь `>= 90` болгож буцаахад 22 тест бүгд ногоон болсон.

## Дүгнэлт

Би `GradeCalculator` классыг бичиж, `letterGrade` болон `totalScore` методуудыг JUnit 5-аар тестэлсэн. Нийт 13 тестийн метод бичсэн бөгөөд `@CsvSource`-ийн мөр бүр тусдаа тест болдог тул `mvn test` 22 тест ажиллуулсан. Дараа нь мутаци хийж, `score >= 90` нөхцөлийг зориуд `score > 90` болгосон. Үр дүнд 22 тестээс 2 нь унасан: `ninetyIsExactlyA` болон `letterGradeBoundaries`-ийн `90,A` мөр, хоёуланд нь `expected: <A> but was: <B>` гарсан. Харин `typicalValues` (95 гэх мэт) болон `zeroAndHundredAreValid` (100) унаагүй, учир нь эдгээр утга 90-ээс хол буюу мутацид мэдрэгдэхгүй. Хамгийн сонирхолтой нь, ердийн утгатай тестүүд ногоон хэвээр байхад яг 90 гэсэн хязгаарын утга л алдааг илрүүлсэн явдал. Үүнээс тест ногоон байна гэдэг нь тест хангалттай гэсэн үг биш, алдаа хязгаар дээр нуугддаг гэдгийг ойлгосон.