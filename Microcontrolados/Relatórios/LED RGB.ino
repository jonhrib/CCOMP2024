// C++ code
//

int ledVermelho = 11;
int ledVerde = 10;
int ledAzul = 9;
int valor = 0;

void setup()
{
  
}

void loop()
{
  for (valor = 0; valor <= 255; valor +=5){
    analogWrite(ledAzul, valor);
    delay(50);
  }
  for (valor = 255; valor >= 0; valor -=5){
    analogWrite(ledAzul, valor);
    delay(50);
  }
  
  for (valor = 0; valor <= 255; valor +=5){
    analogWrite(ledAzul, valor);
    analogWrite(ledVermelho, valor);
    delay(50);
  }
  for (valor = 255; valor >= 0; valor -=5){
    analogWrite(ledAzul, valor);
    analogWrite(ledVermelho, valor);
    delay(50);
  }
  
  for (valor = 0; valor <= 255; valor +=5){
    analogWrite(ledVermelho, valor);
    delay(50);
  }
  for (valor = 255; valor >= 0; valor -=5){
    analogWrite(ledVermelho, valor);
    delay(50);
  }
  
  for (valor = 0; valor <= 255; valor +=5){
    analogWrite(ledVerde, valor);
    analogWrite(ledVermelho, valor);
    delay(50);
  }
  for (valor = 255; valor >= 0; valor -=5){
    analogWrite(ledVerde, valor);
    analogWrite(ledVermelho, valor);
    delay(50);
  }
  
}
