// C++ code
//

int pinoled = 9;
int pinopot = A0;
int valorpot = 0; int brilho =0;

void setup()
{
  Serial.begin(9600);
  pinMode(pinopot, INPUT);
  pinMode(pinoled, OUTPUT);
}

void loop()
{
  valorpot = analogRead(pinopot);
  brilho = map(valorpot,0,1023,0,255);
  analogWrite(pinoled, brilho);
  Serial.print("Valor do potenciometro: ");
  Serial.print(valorpot); Serial.print(" | Brilho do led: ");
  Serial.print(brilho);
}
