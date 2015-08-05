<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/otherpage.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.png" />" type="image/x-icon">
<title>File conversions | Global3dMod</title>
<spring:message code="headerWithSearch.header.search" var="search"/>
</head>
<body>
<%@include file="/WEB-INF/views/header/headerWithSearch.jsp" %>

<div class="container holycontent">
<div class="row">
<div class="font-contact line-contact col-md-12">
<i class="fa fa-file"></i> File conversions  
</div>
</div>
<div class="container">
   <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">In English</a></li>
    <li><a data-toggle="tab" href="#menu1">На русском языке</a></li>
    
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <div class="col-md-12" >
      <p>If you need to print a model on the 3D printer, but it is not saved in .stl format or .wrl, you can use the free online converters, for example <a href=http://assimp.sourceforge.net/>greentoken.de</a>  (limited to 50 MB), or use a graphics program with built-in export format files for 3D printers, such as Google Sketchup, AutoCAD, Autodesk 3ds Max (3D Studio Max), Autodesk Inventor, Mechanical Desktop, Blender, Solidworks, 123D Design, Pixil Bits, OpenSCAD, FreeCAD, Pro ENGINEER, Rhino, Tinkercad (online) 3Dtin (online), and others.</p>
<div class="text-file-conversions-name">AutoCAD:</div>
<div class="text-file-conversions-text ">
Important: export into STL format avialable for integer 3D-objects only. <br>
1. Enter in command line “FACETRES”<br>
2. Set FACETRES parameter equal to 10.<br>
3. Enter “STLOUT” command<br>
4. Select objects for export<br>
5. Press Y or Enter at "Create a binary STL file? [Yes/No]" query<br>
6. Set file name <br>
7. Save file.<br>
</div>
<div class="text-file-conversions-name">Autodesk 3ds Max (3D Studio Max):<br></div>
<div class="text-file-conversions-text ">
1. Open  File > Export)<br>
2. Select type of file — StereoLitho *.stl<br>
3. Enter name of file<br>
4. Save file<br>
5. Set type as Binary<br>
6. Click OK<br>
</div>
<div class="text-file-conversions-name">Autodesk Inventor / Mechanical Desktop:<br></div>
<div class="text-file-conversions-text ">
Important: You can export parts of model or integer models<br>
1. Open Manage tab > Update panel > Rebuild All<br>
2. Open File > Save as > Save Copy As<br>
3. Select file format STL<br>
4. Enter name of file<br>
5. Set the following parameters: Format > Binary, Units > mm or inches, Resolution > High<br>
6. Save file
</div>
<div class="text-file-conversions-name">Google Sketchup:</div>
<div class="text-file-conversions-text ">
If you are using Sketchup Standart (not Pro) you need to install special exestension. 
You can find it <a href=http://www.guitar-list.com/download-software/convert-sketchup-skp-files-dxf-or-stl >here</a>.
Download exestension. For install: Open Sketchup > Window > Preferences > Extensions > Install Extension.<br>
Export in STL:<br>
1. Open Sketchup > Tools > Export to DXF or STL<br>
2. Select object for export. If you not select object, model will export wholly <br>
3. Select units: meters/centimeters/milimeters/inches/feet<br>
4. Set geometry: polyface mesh, polylines, triangular mesh, lines, stl<br>
5. Select place to export file.<br>
</div>
<div class="text-file-conversions-name">Blender:<br></div>
<div class="text-file-conversions-text ">
1. Open File > Export > STL<br>
2. Set file name<br>
3. Select path to file<br>
4. Press "Export STL"<br>
</div>
<div class="text-file-conversions-name">Pro ENGINEER:<br></div>
<div class="text-file-conversions-text ">
1. Open File > Save a Copy<br>
2. Select type STL and click OK<br>
3. Set Coordinate System Standard<br>
4. Set file format  Binary<br>
5. Set the following parameters: Chord Height – 0 (Set minimal Pro/E)<br>
6. Angle Control set as is <br>
7. Enter file name and click OK<br>
</div>
<div class="text-file-conversions-name">Rhino:<br></div>
<div class="text-file-conversions-text ">
1. Open File > Export Selected or File > Save As<br>
2. Select objects for export<br>
3. Set type of file Stereolithography (*.stl)<br>
4. Enter file name<br>
5. Save file<br>
6. In "STL Mesh Export Options" window set "Enter Tolerance" in 0.02 mm (0.0008 inch), then click OK.<br>
7. Set file format Binary<br>
8. Uncheck "Uncheck Export Open Objects"<br>
9. Click OK<br>
</div>
<div class="text-file-conversions-name">Solidworks:<br></div>
<div class="text-file-conversions-text ">
1. Open File > Save As…<br>
2. Set file type STL(*.stl)<br>
3. Open Options<br>
4. Set output file type Binary<br>
5. Unit: > Millimeters or Inches<br>
6. Resolution > Fine<br>
7. Click OK<br>
8. Enter file name<br>
9. Save<br>
</div>
<div class="text-file-conversions-name">SolidWorks Student Design Kit:<br></div>
<div class="text-file-conversions-text ">
1. Open File > Save As…<br>
2. Set file type eDrawings(*.eprt)<br>
3. Open Options<br>
4. Check Allow export to STL for Parts & Assemblies<br>
5. Click OK<br>
6. Enter file name<br>
7. Save file<br>
8. Open file in eDrawings<br>
9. Open File > Save as… > and set file exestension STL (*.stl)<br>
10. Save file<br>
</div>
</div>
    </div>
    <div id="menu1" class="tab-pane fade">
      <div class="col-md-12" >
      <p>Если вам нужно распечатать модель на 3D принтере, но она не сохранена в формате .stl или .wrl, то можно воспользоваться бесплатными онлайн конвертерами, например <a href=http://assimp.sourceforge.net/>greentoken.de</a>  (ограничения до 50 Мбайт) или использовать графические программы со встроенными функциями экспорта в формат файлов для 3D принтеров, например Google Sketchup, AutoCAD, Autodesk 3ds Max (3D Studio Max), Autodesk Inventor, Mechanical Desktop, Blender, Solidworks, 123D Design, Pixil Bits, OpenSCAD, FreeCAD, Pro ENGINEER, Rhino, Tinkercad (онлайн), 3Dtin (онлайн) и др.</p>
<div class="text-file-conversions-name">AutoCAD:</div>
<div class="text-file-conversions-text ">
Важно: экспорт в формат STL возможен только для целых 3D-объектов<br>
1. Введите в командной строке “FACETRES”<br>
2. Установите параметр FACETRES равный 10.<br>
3. Введите команду “STLOUT”<br>
4. Укажите объекты для экспорта<br>
5. Нажмите клавишу Y или Enter на запрос Create a binary STL file? [Yes/No]<br>
6. Укажите имя файла<br>
7. Сохраните файл.<br>
</div>
<div class="text-file-conversions-name">Autodesk 3ds Max (3D Studio Max):<br></div>
<div class="text-file-conversions-text ">
1. Откройте вкладку File > Export)<br>
2. Выберите тип файла — StereoLitho *.stl<br>
3. Введите имя файла<br>
4. Сохраните файл<br>
5. Выберите тип Binary<br>
6. Нажмите OK<br>
</div>
<div class="text-file-conversions-name">Autodesk Inventor / Mechanical Desktop:<br></div>
<div class="text-file-conversions-text ">
Важно: вы можете экспортировать, как отдельные детали, так и целые части модели<br>
1. Откройте вкладки Manage tab > Update panel > Rebuild All<br>
2. Затем откройте File > Save as > Save Copy As<br>
3. Выберите формат файла STL<br>
4. Введите имя файла<br>
5. Установите такие параметры: Формат – бинарный (Format > Binary), единицы измерения – мм или дюймы (Units > mm, inches), разрешение – высокое (Resolution > High)<br>
6. Сохраните файл
</div>
<div class="text-file-conversions-name">Google Sketchup:</div>
<div class="text-file-conversions-text ">
Если вы используете стандартную версию Sketchup, а не Pro, то для экспорта в STL вам нужно будет установить специальное расширение. 
Подходящее под вашу версию Sketchup расширение вы можете найти здесь (http://www.guitar-list.com/download-software/convert-sketchup-skp-files-dxf-or-stl).
Скачайте расширение, для его установки зайдите в Sketchup > Window > Preferences > Extensions > Install Extension.<br>
Для экспорта в STL после установки расширения следуйте следующей инструкции:<br>
1. Зайдите в Sketchup > Tools > Export to DXF or STL<br>
2. Выберите нужный объект для экспорта. Если не выбирать объект, то модель будет экспортирована полностью.<br>
3. Выберите единицы измерения для экспортируемого объекта: meters, centimeters, milimeters, inches, feet<br>
4. Выберите геометрию экспортируемого объекта: polyface mesh, polylines, triangular mesh, lines, stl<br>
5. Выберите, куда предпочтительнее сохранить экспортируемый файл.<br>
Внимание: если вы экспортируете круг с помощью этого плагина, то при просмотре в некоторых других программах вы заметите, что при увеличении он состоит из коротких отрезков.<br>
</div>
<div class="text-file-conversions-name">Blender:<br></div>
<div class="text-file-conversions-text ">
1. Откройте вкладки File > Export > STL<br>
2. Введите имя файла<br>
3. Укажите месторасположения файла<br>
4. Нажмите на кнопку Export STL<br>
</div>
<div class="text-file-conversions-name">Pro ENGINEER:<br></div>
<div class="text-file-conversions-text ">
1. Откройте вкладки File > Save a Copy<br>
2. Выберите тип STL и нажмите OK<br>
3. Установите стандартную систему координат Coordinate System Standard<br>
4. Выберите формат файла Binary<br>
5. Установите следующие параметры Chord Height – 0 (установите минимально допустимые значения Pro/E)<br>
6. Angle Control оставьте по умолчанию<br>
7. Введите имя файла и нажмите OK<br>
</div>
<div class="text-file-conversions-name">Rhino:<br></div>
<div class="text-file-conversions-text ">
1. Откройте вкладки File > Export Selected или File > Save As<br>
2. Выберите объекты для экспорта<br>
3. Установите тип файла Stereolithography (*.stl)<br>
4. Введите имя файла<br>
5. Сохраните файл<br>
6. В окне STL Mesh Export Options установите значение Enter Tolerance в 0.02 мм (0.0008 дюйма), затем нажмите OK.<br>
7. Установите формат файла Binary<br>
8. Снимите галочку с параметра Uncheck Export Open Objects<br>
9. И снова нажмите OK<br>
</div>
<div class="text-file-conversions-name">Solidworks:<br></div>
<div class="text-file-conversions-text ">
1. Откройте вкладки File > Save As…<br>
2. Установите тип файла STL(*.stl)<br>
3. Откройте вкладку Options<br>
4. Установите исходящий формат файла Binary<br>
5. Единицы измерения – миллиметры или дюймы (Unit: > Millimeters or Inches)<br>
6. Разрешение-Хорошее (Resolution > Fine)<br>
7. Нажмите OK<br>
8. Введите имя файла<br>
9. Сохраните<br>
</div>
<div class="text-file-conversions-name">SolidWorks Student Design Kit:<br></div>
<div class="text-file-conversions-text ">
1. Откройте вкладки File > Save As…<br>
2. Установите тип файла eDrawings(*.eprt)<br>
3. Откройте вкладу Options<br>
4. Поставьте галочку в строке Allow export to STL for Parts & Assemblies<br>
5. Нажмите OK<br>
6. Введите имя файла<br>
7. Сохраните файл<br>
8. Откройте файл в eDrawings<br>
9. Откройте вкладки File > Save as… > и установите тип файла STL (*.stl)<br>
10. Сохраните файл<br>
</div>
</div>
    </div>
    
    
  </div>
</div>


</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
<script src="<c:url value="/resources/js/jquery.min.js" />"> </script>
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"> </script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script>
</body>
</html>