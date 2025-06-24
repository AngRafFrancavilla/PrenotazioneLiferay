<%@ include file="./init.jsp" %>
<portlet:actionURL name="/prenotazione" var="prenotazioneActionURL"/>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Form Orari</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light p-4">

  <div class="container">
    <h2 class="mb-4">Prenota Postazione</h2>
<form action="${prenotazioneActionURL}" method="post">
  <div class="mb-3">
    <label for="<portlet:namespace/>email" class="form-label">Inserisci Email</label>
    <input type="email" class="form-control" id="<portlet:namespace/>email" name="<portlet:namespace/>email" required>
  </div>

  <div class="mb-3">
    <label for="<portlet:namespace/>data" class="form-label">Data Prenotazione</label>
    <input type="date" class="form-control" id="<portlet:namespace/>data" name="<portlet:namespace/>data" required>
  </div>

  <div class="row">
    <div class="col-md-6 mb-3">
      <label for="<portlet:namespace/>oraInizio" class="form-label">Ora di Entrata</label>
      <input type="time" class="form-control" id="<portlet:namespace/>oraInizio" name="<portlet:namespace/>oraInizio" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="<portlet:namespace/>oraFine" class="form-label">Ora di Uscita</label>
      <input type="time" class="form-control" id="<portlet:namespace/>oraFine" name="<portlet:namespace/>oraFine" required>
    </div>
  </div>

  <div class="mb-3">
    <label for="<portlet:namespace/>idPostazione" class="form-label">ID Postazione</label>
    
<select class="form-select" id="<portlet:namespace/>postazioneId" name="<portlet:namespace/>postazioneId" required>
  <option value="">Seleziona una postazione</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
  <option value="31">31</option>
</select>

  </div>

  <button type="submit" class="btn btn-primary">Invia</button>
  <button type="reset" class="btn btn-primary">Reset</button>
</form>

  <portlet:renderURL var="dettaglioRenderURL">
  	<portlet:param name="mvcRenderCommandName" value="/dettaglio"/>
  </portlet:renderURL>
	<a href="${dettaglioRenderURL}" class="btn btn-secondary">Dettaglio</a>
  
  </div>

</body>

