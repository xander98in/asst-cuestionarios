INSERT INTO tipo_preguntas (nombre, descripcion) VALUES ('Datos generales', 'Preguntas de datos generales');
INSERT INTO tipo_preguntas (nombre, descripcion) VALUES ('Intralaboral Forma A', 'Preguntas de factores de riesgo psicosocial intralaboral forma A');
INSERT INTO tipo_preguntas (nombre, descripcion) VALUES ('Intralaboral Forma B', 'Preguntas de factores de riesgo psicosocial intralaboral forma B');
INSERT INTO tipo_preguntas (nombre, descripcion) VALUES ('Extralaboral', 'Preguntas de factores psicosociales extralaborales');
INSERT INTO tipo_preguntas (nombre, descripcion) VALUES ('Estr?s', 'Preguntas para la evaluaci?n del estres');

INSERT INTO cuestionarios (titulo, descripcion) VALUES ('Cuestionario de Factores de Riesgo Psicosocial Intralaboral FORMA A', 'Cuestionario para evaluar Factores de Riesgo Psicosocial Intralaboral');
INSERT INTO cuestionarios (titulo, descripcion) VALUES ('Cuestionario de Factores de Riesgo Psicosocial Intralaboral FORMA B', 'Cuestionario para evaluar Factores de Riesgo Psicosocial Intralaboral');
INSERT INTO cuestionarios (titulo, descripcion) VALUES ('Cuestionario de Factores Psicosociales Extralaborales', 'Cuestionario sobre Factores Psicosociales Extralaborales');

INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (1, 2, 'En el lugar donde trabaja hace mucho frio?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (1, 2, 'En el lugar donde trabaja hace mucho calor?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (1, 2, 'El espacio donde trabaja es comodo?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (2, 3, 'Le preocupa accidentarse en su trabajo?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (2, 3, 'El lugar donde trabaja es limpio y ordenado?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (2, 3, 'Trabaja en horario de noche?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (3, 4, 'Es facil transportarse entre su casa y su trabajo?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (3, 4, 'La zona donde vive es segura?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (3, 4, 'Las condiciones de su vivienda son buenas?');

INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (1, 'Dpto de sistemas', 'Dpto de sistemas');
INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (2, 'Dpto de Electr?nica', 'Dpto de Electr?nica');
INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (3, 'Dpto de Telematica', 'Dpto de Telematica');
INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (4, 'Dpto de Matematicas', 'Dpto de Matematicas');
INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (5, 'Dpto de Medicina', 'Dpto de Medicina');
INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (6, 'Dpto de Biologia', 'Dpto de Biologia');
INSERT INTO departamentos (id_departamento, nombre_dep, descripcion) VALUES (7, 'Dpto de Historia', 'Dpto de Historia');
