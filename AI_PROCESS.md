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

ID: PR-08
Objetivo: Corrección de error humano al casi cargar los archivos front en la rama back.
Herramienta: GPT

"Me equivoque e hice el add y commit estando en la carpeta del front, debo deshacer ese commit para cargar los archivos adecuados"

Resultado: Guía con pasos para deshacer el commit antes del push y verificación de estructura.

ID: PR-09
Objetivo: Corregir la propuesta de arquitectura en la guía del punto anterior para separar desde el primer commit front de back.
Herramienta: GPT

"Me genera dudas cargar toda la estructura del proyecto en la rama "feature/backend-initial-setup", no debería crear la rama de front también y cargar desde el inicio la estructura separada? Guiame paso a paso para implementarlo con las mejores practicas, commit por commit incluyendo la rama en la que debo ejecutar cada comando y la carpeta local en la que debo estar ubicado al momento de correrlos"

ID: PR-10
Objetivo: Validar que la carga de archivos fue adecuada, posterior a una captura sin texto la respuesta es que se habían cargado archivos que no debían subirse por su peso y cantidad.
Herramienta: GPT

Resultado: Identificación de un error temprano.

"Se eliminaron los archivos de AI process y .git ignore, recupere el AI process, pero el de ignorar no estaba abierto y por eso debió cargar todo"

Resultado: Indicaciones para crear nuevamente el archivo .gitignore y repetición de algunas instrucciones que parecían ignorar el contexto.

ID: PR-11
Objetivo: Dado que en la respuesta anterior estaba siendo repetitivo e ignorando el nuevo contexto opte por recontextualizar la conversación brindando un resumen para retomar desde ahí.
Herramienta: GPT

"Retomemos desde que se hizo una rama develop en la que se hizo un commit con las carpetas que existian (incluyendo app y api que estaban creadas ya) y una rama feature back, como debemos continuar?"

Resultado: Nuevo plan de acción teniendo en cuenta el contexto real de las ultimas acciones.

ID: PR-12
Objetivo: Previo al commit que cargaría adecuadamente el proyecto valide que estuvieran los archivos adecuadamente.
Herramienta: GPT

"[captura de carpetas del proyecto] Así debe quedar para el commit?"

Resultado: Confirmación y guía de próximos pasos

ID: PR-13
Objetivo: Resolver un error generado al momento de intentar cambiar de rama ya que algunos archivos se tomaron como nuevos y git no les estaba haciendo seguimiento, no estaban incluidos en el commit.
Herramienta: GPT

"[Captura error de consola] Hice el commit de back y al cambiar de rama genera esto"

Resultado: Nuevo commit con los archivos necesarios y organización de los archivos de documentación en el sistema de versiones.

ID: PR-14
Objetivo: Retomar el plan de trabajo inicial, la respuesta anterior proponía profundizar en la parte back.
Herramienta: GPT

"Prosigamos primero cargando la rama front, ya creé la rama feature front, pero al hacer los commits agregando la carpeta frontend/app dice que no hay nada para commit"

Resultado: Ejeucte pruebas de los archivos con algunos comandos git y ya se habían cargado con el commit inicial en la rama develop por lo que sin cambios git no encontraba nada que cargar en el commit, continuando con esa información procedo a configurar angular profesionalmente en lugar de commits artificiales unicamente de estructura.

ID: PR-15
Objetivo: Inicio desarrollo de la solución. Tomé las partes que menciona la situación con relación a la estructura front y back del proyecto sin ahondar aún en formulas ni datos.
Herramienta: GPT

"Queremos construir una herramienta interna para que los líderes de proyecto puedan registrar el avance de sus actividades y entender, en tiempo real, si su proyecto va bien o mal en términos de cronograma y presupuesto. Una aplicación fullstack que permita gestionar proyectos y sus actividades, y que calcule automáticamente los indicadores. Backend Necesitamos una API REST que exponga operaciones para crear, editar y eliminar proyectos y actividades. Cada actividad debe registrar unos datos, el API también debe retornar la interpretación Frontend Un dashboard donde el líder de proyecto pueda ingresar y editar sus actividades, y ver el resultado del análisis en tiempo real. Debe incluir la tabla de actividades con sus indicadores calculados, los indicadores consolidados del proyecto, una indicación visual. Tiene más detalle, pero en este caso no nos es significativo el lado de datos y formulas, lo primero que debemos establecer es la parte estructural de front y back con conexiones api y demás como bases del proyecto"

Resultado: Plantea la arquitectura con la que podemos implementar la aplicación.

ID: PR-16
Objetivo: Empezar la implementación de la parte back del proyecto. La arquitectura planteada por GPT es un desarrollo que permite la escalabilidad y mantiene la flexibilidad al no tener aún datos se mantiene como un desarrollo abstracto.
Herramienta: GPT

"Me parece que es una excelente opción, guíame detalladamente en la implementación, iniciando por la parte back. Es importante que sea estético, pero el objetivo principal es que sea totalmente funcional"

ID: PR-17
Objetivo: Solucionar un detalle técnico en la instalación de postgreSQL (configuración Path) sin alterar el hilo principal que llevo con GPT.
Herramienta: Gemini

"psql --version no se ejecuta bien, no reconoce el comando bash ni la terminal"

Resultado: Configuración correcta en el directorio lo que permitió que la terminal ubicara el programa

ID: PR-18
Objetivo: Identificar como ajustar el comportamiento en el enlace entre spring y postgres ya que al ejecutarlos ambos buscan conectarse al puerto 8080.
Herramienta: GPT

"Al ejecutar ./mvnw spring-boot:run Web server failed to start. Port 8080 was already in use. Aunque más abajo dice Build success Pero al abrir el localhost en ese puerto se muestra una página que dice "EDB postgres Server is up and running.""

resultado: Ajustar el puerto de spring boot para que corra en el 8081.

ID: PR-19
Objetivo: Encontrar el error en la creación del primer endpoint ya que el archivo señalaba un error en el nombre.
Herramienta: GPT

"Creé ese controlador en la carpeta de "controller" con el nombre HealtController.java, pero esta generando error indicando que the public type HealthContoller must be defined in its own file"

resultado: Error de escritura, faltaba una "h" en el nombre del archivo.

ID: PR-20
Objetivo: Validar que la estructura implementada funcionara con spring boot y postgres previo a continuar, esperaba una confirmación después de dar una guía para testear el funcionamiento en los puertos con el endpoint.
Herramienta: GPT

"Todo hasta este punto funciona perfecto, continuemos"

Resultado: Resumen de las herramientas ya validadas y guía para el inicio de modelado del dominio.

ID: PR-21
Objetivo: Probar que los nuevos archivos implementados en las subcarpetas de api (core,dto,entity, etc) funcionaran bien y sin fricción con el resto del desarrollo.
Herramienta: GPT

"Validemos el comportamiento hasta este punto para verificar que esto ultimo funciona bien antes de seguir"

Resultado: Listado de ejecuciones y resultados esperados de cada uno para confirmar el comportamiento.

ID: PR-22
Objetivo: Confirmar que el comportamiento esperado y el actual del sistema son el mismo previo a continuar con los pasos siguientes del proyecto.
Herramienta: GPT

"Localhost funciona
La tabla projects existe con las variables y los tipos incluyendo el id tipo uuid"

Resultado: Confirmación de que la base tecnica está correctamente implementada.

ID: PR-23
Objetivo: Validar si se me estaba pasando algo por alto ya que el paso que indicaba GPT no identificaba como implementarlo, con esta consulta y una instrucción más especifica de su parte pude identificar que no había cambios con respecto a lo que ya estaba en el proyecto y solo estaba siendo repetitivo.
Herramienta: GPT

"Especifica que actualizar en global, el archivo de errorresponse ya está creado con el código"

Resultado: Comprobación de archivos bien configurados y ejecución correcta hasta este punto.

ID: PR-24
Objetivo: Confirmar que todo operaba correctamente con la respuesta de consola para continuar.
Herramienta: GPT

"Build success"

Resultado: Guía con los pasos siguientes para continuar con el desarrollo del proyecto.

ID: PR-25
Objetivo: Confirmar que todo operaba correctamente con la respuesta de consola para continuar.
Herramienta: GPT

"BUILD SUCCESS, continuemos"

Resultado: Resumen de las capas que ya están implementadas y conectadas en el proyecto, seguidas de instrucciones.

ID: PR-26
Objetivo: Realizar las pruebas de CRUD, dentro de los pasos del prompt anterior había una serie de opciones (Postman, Thunder Client o la extensión REST Client) para ejecutar las pruebas, me decante por la extensión REST Client por el control del código y la integración con GIT, pero no la había usado antes por lo que pedí que me guíara en su uso.
Herramienta: GPT

"Instale la extensión de rest client, guíame para sacarle el mayor provecho"

Resultado: Guía en la configuración de los archivos .http para el uso de la extensión.

ID: PR-27
Objetivo: Identificar y corregir la implementación de una variable en uno de los archivos http.
Herramienta: GPT

"projectid genera error, no lo hemos definido dentro de las variables, pero al venir de la respuesta y ser un valor dinámico no considero que deba inicializarse con un valor arbitrario ¿cómo lo podemos resolver?"

Resultado: Se plantean 3 caminos principales que pueden darle solución al error, el primero es una opción manual (más estable, simple y paara la situación fácil de evaluar), la segunda es capturar automaticamente o la tercera, crear un archivo de entorno en donde igual es necesario asignar el UUID. En este caso me decante por la segunda opción al ser la más dinámica.

ID: PR-28
Objetivo: Darle continuidad al proceso después de implementar la corrección y probar que funciona la CRUD en la conexión.
Herramienta: GPT

"La CRUD funciona a la perfección"

Resultado: Resumen de las capas que ya están funcionando y han sido validadas, un analisis del problema especifico (valor ganado) previo a continuar con la implementación.

ID: PR-29
Objetivo: Brindar más contexto de lo que solicita el proyecto con variables, calculos y salidas esperadas.
Herramienta: GPT

"[captura tabla de datos calculados] - Nombre - Presupuesto total planificado (BAC — Budget at Completion) - Porcentaje de avance planificado a la fecha de corte - Porcentaje de avance real completado - Costo real incurrido hasta la fecha (AC — Actual Cost) Con esos datos, el sistema debe calcular automáticamente los siguientes indicadores por actividad y de forma consolidada por proyecto (ver imagen) El API también debe retornar la interpretación de CPI y SPI: si el proyecto está bajo presupuesto o sobre presupuesto, adelantado o atrasado. Un CPI mayor a 1 indica eficiencia en costos; menor a 1 indica que se está gastando más de lo que se avanza. El SPI funciona con la misma lógica pero sobre el cronograma."

Resultado: Una imagen con un relacional y código, una infografía inutil para el desarrollo

ID: PR-30
Objetivo: Aclarar el resultado esperado del prompt anterior.
Herramienta: GPT

"No necesito imagenes, continuemos estructurando el proyecto con la información que te di"

Resultado: Diseño del modelo con la información y una guía de implementación.

ID: PR-31
Objetivo: Indicaciones de como proceder para iniciar la implementación del modelo.
Herramienta: GPT

"Perfecto, iniciemos con el commit para guardar los avances CRUD y demos inicio con la implementación del modelo"

Resultado: Guía para la implementación del modelo.

ID: PR-32
Objetivo: Validación de que la implementación haya sido correcta revisando las tablas creadas en la ejecución, encontrar porque se produce la diferencia entre lo esperado y lo que resulta en la ejecución.
Herramienta: GPT

"[Captura de la terminal] Sí crea las 2 tablas, pero no está la columna projectid en activities"

ID: PR-33
Objetivo: Dar retroalimentación de la falla que se presentaba y confirmar su solución.
Herramienta: GPT

"Listo, no estaba implementado nullable = false) en el joicolumn"

Resultado: Solicito unas validaciones extra para verificar que todo este bien.

ID: PR-34
Objetivo: Informar la diferencia entre lo esperado y el resultado real en la ejecución de las validaciones.
Herramienta: GPT

"Lo único que no muestra es "not null", lo demás incluyendo las llaves están"

Resultado: Guia opcional para eliminar la tabla (drop) y ejecutar nuevamente para que la creación incluyera la restricción de "not null" teniendo en cuenta que una actividad sin proyecto no tiene sentido.

ID: PR-35
Objetivo: Iniciar con el desarrollo de la lógica de la aplicación.
Herramienta: GPT

"Listo, la tabla fue eliminada y creada nuevamente con la restricción "not null" perfecto todo para continuar"

ID: PR-36
Objetivo: Validar que la forma en que se desarrollaron los calculos permita la implementación de un registro en el avance de proyectos evaluando que es lo que pide la prueba y también cual es el alcance del proyecto.
Herramienta: GPT

"Si perfecto, Pruebas unitarias. Toda la lógica de cálculo EVM debe estar cubierta con pruebas unitarias. Esto incluye los casos borde: qué pasa cuando AC es cero, cuando no hay actividades, cuando el avance real es cero y cada endpoint debe test de integración que valide el contrato de respuesta.

Antes de realizar e implementar los test me gustaría validar que estemos cumpliendo con las actividades que propone el requerimiento de funcionamiento front y que efectivamente el usuario pueda realizar estos procesos en la aplicación (comprendiendo que aún no se ha desarrollado nada front) teniendo en cuenta que por lo que comprendo se debe llevar una trazabilidad de los proyectos y por ahora los cálculos no tienen en cuenta algún historico, sé que el valor ganado es como una fotografia del instante en que se evalua, pero me gustaría estar seguro antes de implementar test en calculos mal formulados. 

Requerimiento front 

"Un dashboard donde el líder de proyecto pueda ingresar y editar sus actividades, y ver el resultado del análisis en tiempo real. Debe incluir la tabla de actividades con sus indicadores calculados, los indicadores consolidados del proyecto, una indicación visual del estado de CPI y SPI, y una gráfica que compare PV, EV y AC por actividad."

Resultado: Teniendo en cuenta los plazos y el alcance de la prueba he optado por modificar un poco el funcionamiento para dejar un proyecto que pueda escalarse, dejando la puerta abierta para una eventual implementación de historico.

ID: PR-37
Objetivo: Trazar el plan de trabajo bajo la nueva decisión de dejar la puerta abierta a la escalabilidad de los registros.
Herramienta: GPT

"Está bien, entonces ajustemos lo que pueda ser necesario para dejarlo totalmente escalable para implementar luego el registro y continuemos con lo correspondiente a la prueba"

Resultado: Una respuesta teorica explicando la arquitectura propuesta junto con una explicación de lo que no haría, adicional profundiza en los beneficios de esos ajustes para la implementación de pruebas.

ID: PR-38
Objetivo: Iniciar con la implementación de ajustes.
Herramienta: GPT

"Sí perfecto, implementemos esa mejora, el encapsulamiento con eso sería mucho mejor"

Resultado: Una guía para refactorizar un poco el archivo de calculos para cambiar la forma en que se reciben y devuelven los datos unificando todos los datos calculados en un metodo que internamente llama a los demás generando una unica respuesta con toda la información, lo que va a facilitar las pruebas y el uso de datos en el front, se implemento el patrón de diseño Facade (encapsular lógica compleja detrás de un solo método).

ID: PR-39
Objetivo: Notificar la implementación del refactor y dar aprobación para implementar dentro de la respuesta la interpretación de resultados.
Herramienta: GPT

"Listo el refactor y estoy de acuerdo con el ajuste de incluir los mensajes de interpretación en la respuesta"

Resultado: Respuesta con profundización teorica y opciones de lo que se podría implementar más adelante, mejoras y ajustes que se podrían implementar para mejorar el proyecto.

ID: PR-40
Objetivo: Retomar el flujo de conversación hacia el desarrollo y establecer un orden de tareas antes de implementar mejoras.
Herramienta: GPT

"Ok, pero continuemos con el flujo también de desarrollo porque esta conversación está siendo muy teorica, iniciemos implementando los métodos de interpretación y continuemos con las pruebas, una vez comprobemos y ajustemos hasta que las pruebas estén bien continuamos."

Resultado: Metodos de validación para identificar los casos de acuerdo al resultado de los calculos de spi y cpi junto con metodos de asignación de mensaje para cada caso y una prueba para validar que la refactorización y la inclusión de los nuevos metodos funcionen bien.

ID: PR-41
Objetivo: Iniciar con la implementación de las pruebas en el proyecto.
Herramienta: GPT

"Perfecto, iniciemos con la implementación de pruebas"

Resultado: Guía para la implementación de la primer prueba para validar que se ejecuten las pruebas y todo se encuentre bien configurado.


ID: PR-42
Objetivo: Dar visto bueno para continuar con la implementación de pruebas.
Herramienta: GPT

"Tests run: 2, Failures: 0, Errors: 0, Skipped: 0 Build success"

Resultado: Explicación de la propuesta de implementación de los test junto con la implementación de excepciones desde las variables (para que los datos ingresados tengan sentido antes de intentar realizar cualquier calculo).

ID: PR-43
Objetivo: Retroalimentar sobre el código generado al no identificar que fuera a correr como se esperaba.
Herramienta: GPT

"Vale, en ese código no encuentro que las validaciones llamen a la clase que envia el mensaje de alerta"

Resultado: Corrección en el código teniendo en cuenta la comunicación con las clase que envia el mensaje al usuario.

ID: PR-44
Objetivo: Ajustar el desarrollo para que hubiera una clase de validación porque todo estaba en el mismo archivo de los calculos.
Herramienta: GPT

"Separemos las validaciones en una clase nueva que se encargue de pasar los datos para hacer los calculos solo si son datos validos"

Resultado: Ajuste con la creación de archivos separados que se comunican manteniendo responsabilidades individuales.

ID: PR-45
Objetivo: Encaminar el flujo de trabajo antes de incorporar pruebas o front en añadir el modulo usuarios dentro de la arquitectura para tener la estrucutura completa antes de seguir.
Herramienta: GPT

"Listas las validaciones, antes de continuar con los test (que sabemos van a correr y solo es programarlos) debemos incluir el modulo de usuarios con relacion 1 n con proyectos, incluyendo un usuario y contraseña para tener historial de las actividades por proyecto y que cada usuario pueda ver sus proyectos, actualizarlos y ver el avance con la evaluación en tiempo real"

Resultado: Una propuesta con el nuevo flujo de trabajo incorporado en el flujo principal.

ID: PR-46
Objetivo: Confirmar aprobación para implementar las sugerencias y el nuevo plan de trabajo.
Herramienta: GPT

Resultado: Guía de implementación para la auditoria antes de incluir usuarios.

ID: PR-46
Objetivo: Especificar el paso a paso para implementar la auditoria de la forma correcta para evitar asumir información o pasos que puedan retrasar el proceso.
Herramienta: GPT

"Me gusta la implementación para auditar, pero falta detalle, profundiza en el paso a paso para hacerlo bien y optimizar el tiempo en este desarrollo"

Resultado: Profundización en los pasos incluyendo las rutas y los archivos que debían crearse para implementar adecuadamente la auditoria

ID: PR-45
Objetivo: Encaminar el flujo de trabajo antes de incorporar pruebas o front en añadir el modulo usuarios dentro de la arquitectura para tener la estrucutura completa antes de seguir.
Herramienta: GPT

"El archivo AuditableEntity generaba error porque no tenía los imports adecuados, lo resolví, pero en JpaAuditingConfig los imports que incluí no se ejecutan bien, especialmente import org.springframework.data.jpa.config.EnableJpaAuditing; de ahora en adelante debes incluir los imports necesarios para cada archivo y validar que estén los paquetes y extensiones necesarios para la incorporación de código nuevo"

Resultado: Genero el import correcto junto con una lista de puntos que se volveran obligatorias en las siguientes respuestas como validación de paquetes, imports, ruta de implementación, etc.

ID: PR-46
Objetivo: Confirmar el nuevo metodo de trabajo y confirmar que las correcciones corrieron a la perfección.
Herramienta: GPT

"Sí, considero que ese nuevo modo de trabajar nos va a optimizar la forma de trabajar y aseguramos no avanzar sin haber construido todo lo que se necesita en cada etapa, la ejecución de ./mvnw clean compile funcionó bien"

Resultado: Modificaciones en la forma de manejar los id´s y validación del funcionamiento hasta la BD con los ajustes.

ID: PR-47
Objetivo: Mostrar resultado de la prueba.
Herramienta: GPT

"[Insersión de imagen con el resultado de la tabla]"

Respuesta: Las tablas de auditoria no están funcionando bien y no se crearon las columnas de trazabilidad

ID: PR-48
Objetivo: Dar el contexto solicitado junto con lo que considero que podría ser la solución.
Herramienta: GPT

"[Código de 3 archivos] Creería que puede ser necesario borrar la base y volverlo a ejecutar para que lo cree las tablas con los datos de auditoria, te comparto el codigo de los archivos solicitados para auditoria"

Resultado: Validaciones e intentos que permitieran seguir sin borrar la base de datos.

ID: PR-49
Objetivo: Dar el contexto solicitado.
Herramienta: GPT

"[Código de la terminal relacionado con el funcionamiento de hibernate]"

Resultado: Validación de las soluciones intermedias

ID: PR-50
Objetivo: Respuesta de la consulta en la BD sobre la columna.
Herramienta: GPT

"no existe la columna «created_at»"

Resultado: Consultas SQL para validar que fuera la BD correcta, que estuviera publica y que no estén las tablas y columnas que deben crearse al levantar el servicio.

ID: PR-51
Objetivo: identificar la falla que impide la creación de las columnas de auditoria.
Herramienta: GPT

"[Bloque de código relacionado a hibernate cuando se estaba subiendo el servicio]"

Resultado: Identificación de la falla y solución, eliminar la BD y subir el servicio para que se cree de 0 con los nuevos campos.