package edu.teamrocket.Logica;

import java.util.EnumSet;

public enum Planeta {
    Mercurio(3.303e+23, 2.4397e6),
    Venus(4.869e+24, 6.0518e6),
    Tierra(5.976e+24, 6.37814e6),
    Marte(6.421e+23, 3.3972e6),
    Jupiter(1.9e+27, 7.1492e7),
    Saturno(5.688e+26, 6.0268e7),
    Urano(8.686e+25, 2.5559e7),
    Neptuno(1.024e+26, 2.4746e7);

public static final double G = 6.67300E-11;

private double masa;
private double radio;

private Planeta(double masa, double radio) {
    this.masa = masa;
    this.radio = radio;

}

public double getMasa() {
    return masa;
}

public double getRadio() {
    return radio;
}

public double pesoEnSuperficie(double peso) {
    return masaHumano(peso) * this.gravedadSuperficial();
}

public double masaHumano(double peso) {
    return peso / this.gravedadSuperficial(Tierra);
}

public double gravedadSuperficial() {
    return G * this.masa / (this.radio * this.radio);
}

public double gravedadSuperficial(Planeta planeta) {
    return G * planeta.getMasa() / (planeta.getRadio() * planeta.getRadio());
}

public static EnumSet<Planeta> getPlanetasTerrestres() {
		return EnumSet.range(Mercurio, Marte);
	}

public static EnumSet<Planeta> getGigantesGaseosos() {
	return EnumSet.complementOf(getPlanetasTerrestres());
}

}
