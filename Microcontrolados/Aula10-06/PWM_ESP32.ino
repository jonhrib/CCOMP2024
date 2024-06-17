#define pinoSensor 34
int verde = 25;
int amarelo = 26;
int vermelho = 27;
int buzzer = 14;
int valorSensor = 0;
float voltagem;

void setup() {
  Serial.begin(115200);
  pinMode (25, OUTPUT);
  pinMode (26, OUTPUT);
  pinMode (27, OUTPUT);
  pinMode (14, OUTPUT);
  delay(100);
}

void loop() {
  valorSensor = analogRead(pinoSensor);
  voltagem = valorSensor * (3.3 / 4095);
  
  digitalWrite(verde, LOW);
  digitalWrite(amarelo, LOW);
  digitalWrite(vermelho, LOW);

  if (valorSensor > 0 && valorSensor <= 4095){
    digitalWrite(verde, HIGH);
    // digitalWrite(amarelo, LOW);
    // digitalWrite(vermelho, LOW);
    if (valorSensor <= 2730 && valorSensor >= 1365){
      digitalWrite(amarelo, HIGH);
      // digitalWrite(vermelho, LOW);
    }
    else if (valorSensor > 2730) {
      digitalWrite(amarelo, HIGH);
      digitalWrite(vermelho, HIGH);
    }
  }

  if (valorSensor == 4095){
    digitalWrite(buzzer, HIGH);
  }
  else{
    digitalWrite(buzzer, LOW);
  }
  
  Serial.print("Tensão do Potenciômetro: ");
  Serial.print(voltagem);
  Serial.println(" V");
  
  Serial.print("Valor do Sensor: ");
  Serial.println(valorSensor);
  
  delay(1000);
}