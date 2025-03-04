

Vilka ansvarsområden har era klasser?
CarController bör kontrollera bilarna, men där körs även hela programmet ifrån
DrawPanel ska rita upp bilderna
CarView skapar knappar

Vilka anledningar har de att förändras?
CarController har för högt ansvar den bör delas upp mer.
DrawPanel temporärt lagrar positionerna för fordonen, istället för att skickas direkt till paintComponent.

På vilka klasser skulle ni behöva tillämpa dekomposition för att bättre följa SoC och SRP?
CarController.


