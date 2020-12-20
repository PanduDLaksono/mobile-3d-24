package org.dotapedia;

public class Info {
    private String nama, kelas, NIM, github;

    public Info(String nama, String kelas, String NIM, String github) {
        this.nama = nama;
        this.kelas = kelas;
        this.NIM = NIM;
        this.github = github;
    }

    public Info() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
