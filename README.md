# Ollama CV Insight

AI destekli PDF özgeçmiş analiz servisi.  
Spring Boot ve Ollama TinyLLaMA modeli kullanılarak geliştirilmiştir.

---

## 🚀 Proje Hakkında

Bu proje, PDF formatındaki CV dosyalarını okuyup içeriğini yapay zekâ ile analiz ederek:

- Güçlü yönleri,
- Eksik becerileri,
- Uygun pozisyon önerilerini

çıkarır ve 100 üzerinden puanlama yapar.

---

## ⚙️ Teknolojiler

- Java 17+
- Spring Boot
- Spring AI (Ollama TinyLLaMA entegrasyonu)
- Apache PDFBox (PDF metin çıkarma)
- OpenAPI / Swagger UI

---

## 📥 Kurulum

### 1. Ollama Model Sunucusunu Kurma

Bu proje, Ollama TinyLLaMA modelini yerel olarak kullanır. Ollama'yı aşağıdaki adımlarla kurabilirsiniz:

- Ollama için resmi sayfa: [https://ollama.com](https://ollama.com)  
- MacOS veya Linux için terminalde:

```bash
# Ollama'yı yükleyin (örn. Homebrew ile MacOS için)
brew install ollama

# TinyLLaMA modelini indirip çalıştırın
ollama run tinyllama


### 2. Projeyi Klonlama ve Çalıştırma
git clone https://github.com/orhanturkmenoglu/ollama-cv-insight.git
cd ollama-cv-insight
./mvnw spring-boot:run

---
🚩 API Kullanımı
Metin tabanlı AI sohbet:
GET /api/chat/ask?userInput=merhaba

PDF CV Analizi:
POST /api/chat/analyze
Form-data içinde file parametresi ile PDF dosyasını gönderin.

PDF Metin Okuma:
POST /api/pdf/read
Form-data içinde file parametresi ile PDF dosyasını gönderin.

⚡️ Notlar
Ollama TinyLLaMA modeli, düşük kaynaklarla hızlı ve etkili analiz sunar.

Daha gelişmiş modeller ve Docker desteği yakında eklenecektir.



