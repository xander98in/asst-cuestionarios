INSERT INTO `tipo_preguntas` (`id_tipo_pregunta`, `nombre`, `descripcion`) VALUES (1, 'Datos generales', 'Preguntas de datos generales');
INSERT INTO `tipo_preguntas` (`id_tipo_pregunta`, `nombre`, `descripcion`) VALUES (2, 'Intralaboral', 'Preguntas de factores de riesgo psicosocial intralaboral');
INSERT INTO `tipo_preguntas` (`id_tipo_pregunta`, `nombre`, `descripcion`) VALUES (3, 'Extralaboral', 'Preguntas de factores psicosociales extralaborales');
INSERT INTO `tipo_preguntas` (`id_tipo_pregunta`, `nombre`, `descripcion`) VALUES (4, 'Estr�s', 'Preguntas para la evaluaci�n del estr�s');


INSERT INTO cuestionarios (titulo, descripcion) VALUES ('Cuestionario de Factores de Riesgo Psicosocial Intralaboral FORMA A', 'Cuestionario para evaluar Factores de Riesgo Psicosocial Intralaboral');
INSERT INTO cuestionarios (titulo, descripcion) VALUES ('Cuestionario de Factores de Riesgo Psicosocial Intralaboral FORMA B', 'Cuestionario para evaluar Factores de Riesgo Psicosocial Intralaboral');
INSERT INTO cuestionarios (titulo, descripcion) VALUES ('Cuestionario de Factores Psicosociales Extralaborales', 'Cuestionario sobre Factores Psicosociales Extralaborales');

INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (1, 1, '�En el lugar donde trabaja hace mucho frio?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (1, 1, '�En el lugar donde trabaja hace mucho calor?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (1, 1, '�El espacio donde trabaja es comodo?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (2, 1, '�Le preocupa accidentarse en su trabajo?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (2, 1, '�El lugar donde trabaja es limpio y ordenado?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (2, 1, '�Trabaja en horario de noche?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (3, 3, '�Es facil transportarse entre su casa y su trabajo?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (3, 3, '�La zona donde vive es segura?');
INSERT INTO preguntas (id_cuestionario, id_tipo_pregunta, enunciado) VALUES (3, 3, '�Las condiciones de su vivienda son buenas?');