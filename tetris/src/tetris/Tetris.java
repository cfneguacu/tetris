package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tetris extends JPanel{

public class Tela extends JFrame{

public Tela() {
setSize(726,700);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setResizable(false);
}
}//fim da class tela

//Inicio da Class Jogo
public class jogo extends JPanel{
// variaveis
int XX=0,YY=0;
int M0useX=0,M0useY=0;
int variavel=1;
int dim=17;
int pared=dim-1;
boolean vv=true;
int Numero;
int N;
//==========

public void CordenadaMouse(int M0useX,int M0usey) throws IOException{

this.M0useX=M0useX;
this.M0useY=M0usey;
if(XX<=596&&XX>=488&&YY<=86&&YY>=59){
System.err.println("correr");

}

if(449<=XX&&XX<=595&&95<=YY&&YY<=121){
PausePlay();

}
if(450<=XX&&XX<=594&&132<=YY&&YY<=155){
int sair=JOptionPane.showConfirmDialog(null, "Quer mesmo sair?","atencao",JOptionPane.YES_NO_OPTION);
if(sair==JOptionPane.YES_OPTION)
System.exit(0);


// JOptionPane.showMessageDialog(null, "tentou sair");
}

}

public void Cordenadas(int x,int y){
XX=x;
YY=y;

repaint();
}
public jogo() {

// Mouse Movimento
addMouseMotionListener(new MouseMotionListener(){

public void mouseMoved(MouseEvent e) {
Cordenadas(e.getX(),e.getY());
}
public void mouseDragged(MouseEvent e) {
}
});


// Mouse Clickes
addMouseListener(new MouseListener() {

@Override
public void mouseClicked(MouseEvent e) {
try {
CordenadaMouse(XX,YY);
// System.err.println(" X = "+XX+" Y= "+YY);
} catch (IOException ex) {
Logger.getLogger(jogo.class.getName()).log(Level.SEVERE, null, ex);
}
}

@Override
public void mousePressed(MouseEvent e) {

}

@Override
public void mouseReleased(MouseEvent e) {

}

@Override
public void mouseEntered(MouseEvent e) {

}

@Override
public void mouseExited(MouseEvent e) {

}

});
}


//=======Variaves========
int y,x,Rotacao=0;//nivel 1
public Point OrigemPreca ;
public Color Parede[][];//nivel 2
public ArrayList<Integer> ProximaPeca = new ArrayList<Integer>();//nivel 3
public int PecaAtual;
public Color[] tetraminoColors = {
new Color(0, 0, 153), new Color(204,0,204), new Color(0, 102, 102), new Color(255, 102, 0), Color.green, Color.cyan, Color.red
};
//======================

Point Tetri[][][]={// 0
// I-Piece
{
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
},
// 1
{
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
},
// 2
{
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
{ new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
},
// 3
{
{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
{ new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
},
// 4
{
{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
{ new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
{ new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
},
// 5
{
{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
{ new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
{ new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
},
// 6
{
{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
{ new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
{ new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
}
};


@Override
protected void paintComponent(Graphics g) {
g.setColor(Color.black);
g.fillRect(0, 0,900,700);

Desenhar( g);
}
boolean ver;
void verdade(){
if(!ver){
repaint();
ver=true;
}
}
public void Desenhar(Graphics g){
// Graphics2D grafico=(Graphics2D)g;
for(int i=0; i < dim; i++){
for(int j=0; j < 32; j++){
g.setColor(Parede[i][j]);
g.fillRect(21*i, 21*j,20,20);
}
}
verdade();


// tetris
g.setColor(tetraminoColors[PecaAtual]); //Cor Do Teris
for(Point p:Tetri[PecaAtual][Rotacao]){
g.fillRect((p.x+OrigemPreca.x)*21+x,(p.y+OrigemPreca.y)*21+y,20,20);
}
g.setColor(tetraminoColors[Vglobal]); //Cor Do Teris
for(Point c:Tetri[Vglobal][0]){
g.fillRect((c.x+23)*21,(c.y+14)*21,20,20);
}
// cordenadas
g.setColor(Color.red);
//g.drawString("localisação em X ="+XX+" localisação em Y="+YY, 400, 200);

//g.fillRect(448, 60, 150,30);
//g.fillRect(448, 60+35, 150,30);
//g.fillRect(448, 60+70, 150,30);
//menu de butão
String palavrasmenu[]={"INICIO","PAUSE/PLAY","SAIR"};
for(int i=0;i < 3;i++){
g.fillRect(448, 60+35*i, 150,30);

}
for(int i=0;i < 3;i++){
if(i==1&&vv==false){
g.setColor(Color.yellow);
g.fillRect(448, 60+35*i, 150,30);
}else if(i!=1){
g.setColor(Color.red);
g.fillRect(448, 60+35*i, 150,30);
}

g.setColor(Color.red);
g.drawString("REI:"+REI, 600, 20);
}

for(int i=0;i < 3;i++){
g.setColor(Color.GREEN);
g.drawString(palavrasmenu[i], 448+40, 80+30*i);
}
g.setColor(Color.red);
//String palavras[]={"PONTUAÇÃO: "+cont,"NIVEL"+Nivel,"MELHOR PONTUAÇÃO: "+pontos.MostraPontos(),"USUARIO"};
g.drawRect(449, 233, 150, 150);
//g.drawString("PONTUAÇÃO", 448, 433);
for(int i=0; i < 4;i++){
//g.drawString(palavras[i], 448, 433+30*i);
}

}

//Nivel 2
//=======Toda logica é chamada neste Metodo=======
public void Motor() throws InterruptedException{
Parede =new Color[20][32];
for(int i=0; i<pared; i++){
for(int j=0; j < 32; j++){

if(i==0||i==pared||j==31){
Parede[i][j]=Color.orange;
}else{
Parede[i][j]=Color.PINK;
}

}
}
//
NovaPeca();
}

public boolean Colisao(int x, int y, int rotacao){
for(Point p: Tetri[PecaAtual][rotacao]){
if(Parede[p.x+x][p.y+y]!=Color.PINK){
return true;
}
}
//// System.out.println("false");
return false;

}

public void correr(){
new Thread(){
@Override
public void run() {

while(true){
try {

baixar();
if(cont==0){
Nivel=1;
sleep(1000);
}
if(cont >= 1&&cont < 3){
Nivel=1;
sleep(700);
} if(cont >= 3&&cont<6){
Nivel=2;
sleep(500);
}
if(cont>=6&&cont<9){
Nivel=3;
sleep(300);
}
if(cont>=9&&cont<12){
Nivel = 4;
sleep(200);
}
if(cont>=12&&cont<15){
Nivel = 5;
sleep(150);
}
if(cont>=15){
sleep(150);
}

} catch (Exception e) {
}
}
}
}.start();
}

//=============Rotação das Peças=================
public void Rotacao(int v){
if(vv){
int NovaRotacao=(Rotacao+v)%4;
// System.out.println(" Rotacao: "+NovaRotacao);
if(NovaRotacao<0){
NovaRotacao=3;
}
if(!Colisao(OrigemPreca.x, OrigemPreca.y, NovaRotacao)){
Rotacao=NovaRotacao;
// System.out.println("ola");
}}
repaint();
}
//=============================================

//== Movimentos Das Peças direita esquerda e baixo assim como as colisoes com a parede==
void baixar() throws IOException, InterruptedException{
if(!Colisao(OrigemPreca.x, OrigemPreca.y+1, Rotacao)){
OrigemPreca.y+=variavel;
if(vv){
repaint();
}
}else{
Montar();
}
repaint();
}

void direita(){
if(!Colisao(OrigemPreca.x+1, OrigemPreca.y, Rotacao)){
OrigemPreca.x+=variavel;

}
repaint();
}

void esquerda(){
if(!Colisao(OrigemPreca.x-1, OrigemPreca.y, Rotacao)){
OrigemPreca.x-=variavel;

}
repaint();
}
//====================================================================

//3-Nivel
int Vglobal;
public void NovaPeca() throws InterruptedException{
OrigemPreca = new Point(dim/2-1, 0);

Random r= new Random();
int estatico=r.nextInt(7);
int peca=Vglobal+0;
for(int i=0; i<2;i++){
Vglobal=r.nextInt(7);
}


if(ProximaPeca.isEmpty()){
Collections.addAll(ProximaPeca, peca);//Escolhas
Collections.shuffle(ProximaPeca);// responsavel pela Aleatoriedade
}
sleep(1);
PecaAtual=ProximaPeca.get(0);
// System.err.println(""+PecaAtual);
ProximaPeca.remove(0);//Remove a peca atual

// if(!ProximaPeca.isEmpty()){
// System.out.println("verdade");
// }

}

public void Montar() throws IOException, InterruptedException{
for(Point p: Tetri[PecaAtual][Rotacao]){
Parede[OrigemPreca.x + p.x][OrigemPreca.y + p.y] = tetraminoColors[PecaAtual];
}
LiparLinha();
NovaPeca();
}
int cont=0;
int Nivel=0;

public void Destruir(int linha,int N){
for (int j = linha-1-N; j > 0; j--) {
for (int i = 1; i < dim; i++) {
Parede[i][j+1] = Parede[i][j];
}
}
}

public void LiparLinha() throws IOException {
boolean Buraco;
Numero = 0;
for (int j = 30; j > 0; j--) {
Buraco = false;
for (int i = 0; i < dim; i++) {
if (Parede[i][j] == Color.PINK) {
Buraco = true;
break;
}
}

if (!Buraco) {
Destruir(j,N);
j += 1;
Numero += 1;
cont++;
pontos() ;
}
}

}

void PausePlay() {
vv=!vv;
if(vv){
variavel=1;
}else
variavel=0;
}

public int contar(){
return cont;
}
//dados pontos = new dados();
String REI;
int contRei=1;
//int ponto =Integer.parseInt(pontos.MostraPontos());
void pontos() throws IOException{

//if(cont>ponto){
//pontos.EntrarDados(""+cont);
contRei++;
System.out.println(""+contRei);
Reinado();
}
}

void Reinado() throws IOException{
//if(cont>ponto&&contRei==2){
//PausePlay() ;
//REI=JOptionPane.showInputDialog("Digite o seu Nome Meu Rei");
//pontos. MeuRei(REI) ;
//if(REI!=null){
//PausePlay() ;
}
//}
//}

//public String getREI() {
//return REI;
//}

public void setREI(String REI) {
//this.REI = REI;
}
//}//fim da class Jogo

//Construtor
public Tetris() throws InterruptedException {

tudo() ;
}

boolean vvv=true;
public void tudo() throws InterruptedException{

Tela tela=new Tela();
jogo jog=new jogo();
tela.add(jog);


jog.correr();
jog.Motor();

tela.addKeyListener(new KeyListener() {
@Override
public void keyTyped(KeyEvent e) {

}

@Override
public void keyPressed(KeyEvent e) {
switch (e.getKeyCode()) {
case KeyEvent.VK_LEFT:
jog.esquerda();
break;
case KeyEvent.VK_RIGHT:
jog.direita();
break;
case KeyEvent.VK_UP:
int v=1;
jog.Rotacao(v);
break;
case KeyEvent.VK_DOWN:
int v2=-1;
jog.Rotacao(-1);
break;
case KeyEvent.VK_SPACE:
{
try {
jog.baixar();
} catch (IOException ex) {
Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
} catch (InterruptedException ex) {
Logger.getLogger(Tetris.class.getName()).log(Level.SEVERE, null, ex);
}
}
break;
case KeyEvent.VK_ENTER:
jog.PausePlay();
break;
}

}

@Override
public void keyReleased(KeyEvent e) {

}

});


}

public static void main(String[] args) throws InterruptedException {
new Tetris();
}

}