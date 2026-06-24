IA utilizadas:

Siendo coherente con la honestidad que busca el equipo en este documento me gustaría aclarar que llevo algún tiempo sin programar, por este motivo hice algunas consultas en mi celular a Gemini buscando algo de orientación para estructurar mi proceso mental, dentro de las consultas estaba que IA´s utilizar y dentro de las opciones me decante por la extensión de github copilot al ser la más usada por la industria y chatgpt por su trayectoria y madurez como tecnología (además que la he utilizado en otras labores relacionadas con tecnología y me ha sido muy útil, sus capacidades en identificación y corrección de errores considero será de gran aporte en el proceso), con el objetivo de crear un hilo límpio de conversación en chatgpt lo más eficiente y enfocado posible le solicite a Gemini los componentes de un prompt ideal, una vez los listo y profundizo (un recordatorio que buscaré implementar en cada consulta relacionada a este desarrollo), le solicite "el primer prompt para la documentación", pero considero que el primero debe ser precisamente el de Gemini ya que es desde este que inicia el desarrollo del proyecto.

ID: PR-01
Objetivo: Confirmación de herramienta IA y redacción primer prompt inicio del proyecto.
Herramienta: Gemini

"Listo, redacta el primer prompt dándole el mejor rol senior para la realización de esta prueba solicitando que me guíe para primero que todo preparar el entorno teniendo en cuenta que nunca he programado en este computador, menciona que ya está instalado github app, git y visual studio, además de la extensión de github copilot, esto ya que va a ser el primer prompt para la documentación, para copiar y pegar en un chat nuevo, para esta tarea el mejor sería gpt? Teniendo en cuenta trayectoria y capacidad para guiarme en esto desde la parte técnica?"

Resultado: "Para este tipo de tareas, GPT (especialmente en sus versiones recientes) o Claude (de Anthropic) son las opciones líderes indiscutibles. GPT cuenta con una trayectoria impecable estructurando tutoriales de configuración técnica, y su capacidad para seguir instrucciones de forma estructurada e interpretar errores de consola es brillante. Es, sin duda, una excelente elección para abrir tu chat de base y usarlo como el consultor principal de tu documentación. ​Aquí tienes el primer prompt oficial perfectamente estructurado bajo buenas prácticas de ingeniería de prompts. Está diseñado para que solo tengas que copiarlo, pegarlo en tu nuevo chat, y guardarlo directamente en tu archivo

[Prompt ID: PR-02]"

ID: PR-02
Objetivo: Preparación integral del entorno de desarrollo local y primer commit de arquitectura base.
Herramienta: GPT

"[ROL]
Actúa como un Arquitecto de Software Full Stack Senior y Mentor Técnico. Tienes años de experiencia desplegando entornos corporativos basados en arquitecturas desacopladas con Angular en el Frontend y Java con Spring Boot en el Backend.
​[CONTEXTO]
Estoy iniciando una prueba técnica para un proceso de selección. El repositorio de GitHub ya está creado y clonado en mi máquina local. Actualmente, esta computadora está limpia y nunca se ha programado en ella, por lo que carece de entornos globales de ejecución.
​Dispongo de las siguientes herramientas ya instaladas en el sistema:
​Git y terminal de comandos configurada.
​GitHub Desktop (GitHub App).
​Visual Studio Code como editor principal (con la extensión GitHub Copilot activa).
​[TAREA]
Necesito que me guíes paso a paso, de manera clara, técnica y secuencial para preparar mi entorno de desarrollo desde cero. La guía debe cubrir:
​Descarga, instalación y verificación de las versiones estables recomendadas para Node.js/Angular CLI y Java JDK (apuntando a Spring Boot 3.x).
​Configuración de extensiones o utilidades críticas en Visual Studio Code para trabajar con Java y Angular simultáneamente de forma cómoda.
​El procedimiento exacto para inicializar un proyecto Angular limpio dentro de una carpeta /frontend y un proyecto Maven de Spring Boot estructurado dentro de una carpeta /backend, asegurando un enfoque de monorrepo limpio.
​[RESTRICCIONES Y FORMATO]
​No omitas comandos de verificación (como comprobar que las variables de entorno o versiones estén bien instaladas).
​Entrega las instrucciones divididas por bloques lógicos (Paso 1, Paso 2...).
​Evita introducciones corporativas extensas; ve directo a las acciones técnicas y comandos de consola que debo ejecutar. Sugiéreme las mejores opciones estándar de la industria (ej. qué JDK elegir o qué dependencias iniciales usar) para asegurar que el proyecto final sea robusto y moderno."

Resultado: Guía estructurada en pasos para la instalación y comprobación de los paquetes para el entorno (java, node, maven, npm, angular, extensiones para vscode: ESLint, Prettier, Error Lens, GitLens, Material Icon Theme) 

ID: PR-03
Objetivo: Profundización en la preparación integral del entorno de desarrollo local.
Herramienta: GPT

"Cómo instalo maven? No tiene un archivo ejecutable"

Resultado: Guía para crear variables de entorno para el uso global de maven

ID: PR-04
Objetivo: Solución error inicio angular
Herramienta: GPT

"Genera error el bash al ejecutar "ng new app --routing --style=scss""

Resultado: Preguntas diagnosticas del error

ID: PR-05
Objetivo: Definición de la falla para dar solución.
Herramienta: GPT

"[Foto del error] En git bash si aparece instalado, en la terminal no y en powershell no"

Resultado: Guía para modificar politicas de seguridad

ID: PR-06
Objetivo: Consulta falla poco común en la ejecución de los paquetes.
Herramienta: GPT

"Todas las versiones de los paquetes están instaladas correctamente, pero al posicionarme dentro de la carpeta frontend del proyecto no arroja la versión de ninguno de los paquetes, como si no estuviera nada instalado"

Resultado: "Lo que describes no es el comportamiento normal. Las herramientas instaladas globalmente (node, npm, java, mvn, ng) deberían funcionar desde cualquier carpeta del sistema." Adicional a una serie de pasos para verificar que puede estar fallando, entre la respuesta mencionó que podía ser porque durante las instalaciones estaba vscode abierto por lo que decidí reiniciar el programa y en efecto desde ahí tomó todos los paquetes adecuadamente.

ID: PR-07
Objetivo: Implementación de condiciones para el uso del repositorio Github con buenas practicas.
Herramienta: GPT

"Antes de hacer el primer commit es fundamental que se implementen estas condiciones como parte del proceso y buenas practicas: La estructura de ramas debe seguir el flujo estándar: main para producción, develop como rama de integración, ramas feature/* por cada funcionalidad, y al menos una rama release/* antes del merge final a main. Cada feature debe integrarse a develop mediante un Pull Request, aunque trabajes solo. Los mensajes de commit deben ser descriptivos y en imperativo: Add EVM calculation service, Fix CPI edge case when AC is zero. Mensajes como fix, cambios o wip no son aceptables."

Resultado: Corrección de la sugerencia inicial de hacer commit directo a main y guía con nuevos pasos
