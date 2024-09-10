package com.example.tasktide.Objetos;

public class Informacoes {
    private String dataPrevis;
    private String dataFim;
    private String horarioInicio;
    private String horarioFim;
    private String prazo;
    private String local;
    private String pago; // Sim ou Não
    private Double valorEvento;

    // Construtor padrão
    public Informacoes() {}

    // Construtor com parâmetros
    public Informacoes(String dataPrevis, String dataFim, String horarioInicio, String horarioFim, String prazo, String local, Double valorEvento, String pago) {
        this.dataPrevis = dataPrevis;
        this.dataFim = dataFim;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.prazo = prazo;
        this.local = local;
        this.valorEvento = valorEvento;
        this.pago = pago;
    }

    // Getters
    public String getDataPrevis() { return dataPrevis; }
    public String getDataFim() { return dataFim; }
    public String getHorarioInicio() { return horarioInicio; }
    public String getHorarioFim() { return horarioFim; }
    public String getPrazo() { return prazo; }
    public String getLocal() { return local; }
    public String getPago() { return pago; }
    public Double getValorEvento() { return valorEvento; }

    // Setters
    public void setDataPrevis(String dataPrevis) { this.dataPrevis = dataPrevis; }
    public void setDataFim(String dataFim) { this.dataFim = dataFim; }
    public void setHorarioInicio(String horarioInicio) { this.horarioInicio = horarioInicio; }
    public void setHorarioFim(String horarioFim) { this.horarioFim = horarioFim; }
    public void setPrazo(String prazo) { this.prazo = prazo; }
    public void setLocal(String local) { this.local = local; }
    public void setPago(String pago) { this.pago = pago; }
    public void setValorEvento(Double valorEvento) { this.valorEvento = valorEvento; }
}
