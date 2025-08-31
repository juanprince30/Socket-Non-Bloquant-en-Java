# TP-Socket (Java)

Ce projet illustre l’utilisation des **sockets en Java** en mode bloquant et non-bloquant.  
Il est divisé en deux parties principales :  

1. **Client TCP classique** (utilisation via un client codé en Java).  
2. **Socket Non Bloquant** utilisant `java.nio` pour gérer les connexions.

---

## 📂 Arborescence du projet


```
TP-Socket
├─ client TCP
│  ├─ .idea
│  │  ├─ misc.xml
│  │  ├─ modules.xml
│  │  └─ workspace.xml
│  ├─ client TCP.iml
│  ├─ out
│  │  └─ production
│  │     └─ client TCP
│  │        ├─ ClientSocket.class
│  │        └─ Main.class
│  └─ src
│     ├─ ClientSocket.java
│     └─ Main.java
├─ README.md
└─ Socket No blocking
   ├─ .idea
   │  ├─ inspectionProfiles
   │  │  └─ Project_Default.xml
   │  ├─ misc.xml
   │  ├─ modules.xml
   │  └─ workspace.xml
   ├─ out
   │  └─ production
   │     └─ Socket No blocking
   │        ├─ Main.class
   │        └─ NonBlockingSocket.class
   ├─ Socket No blocking.iml
   └─ src
      ├─ Main.java
      └─ NonBlockingSocket.java

```

---

## ⚡ Partie 1 : Client TCP

Dans ce module, nous implémentons un **client TCP basique** qui se connecte à un serveur via un socket classique (`java.net.Socket`) au port 5000.

### Lancement
1. Compiler :
   ```bash
   javac src/*.java -d out
   ```
2. Exécuter le serveur avec telnet sur le port 5000 :
    ```bash
   telnet localhost 5000
   ```
3. Exécuter le client TCP en Java :
    ```bash
   java -cp out Main
   ```
4. Démarrer un serveur TCP (exemple avec **netcat** sous Linux/macOS) :
   ```bash
   nc -l -p 1234
   ```

