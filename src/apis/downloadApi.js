const exportData = () => {
    /* Get the HTML data using Element by Id */
    var table = document.getElementById("requests-table");

    /* Declaring array variable */
    var rows =[];

      //iterate through rows of table
    for(var i=0,row; row = table.rows[i];i++){
        //rows would be accessed using the "row" variable assigned in the for loop
        //Get each cell value/column from the row
        let column1 = row.cells[0].innerText;
        let column2 = row.cells[1].innerText;
        let column3 = row.cells[2].innerText;
        let column4 = row.cells[3].innerText;
        let column5 = row.cells[4].innerText;
        let column6 = row.cells[5].innerText;
        let column7 = row.cells[7].innerText;
        let column8 = row.cells[8].innerText;
        let column9 = row.cells[9].innerText;






    /* add a new records in the array */
        rows.push(
            [
                column1,
                column2,
                column3,
                column4,
                column5,
                column6,
                column7,
                column8,
                column9
            ]
        );

        }
        let csvContent = "data:text/csv;charset=utf-8,";
         /* add the column delimiter as comma(,) and each row splitted by new line character (\n) */
        rows.forEach(function(rowArray){
            row = rowArray.join(",");
            csvContent += row + "\r\n";
        });

        /* create a hidden <a> DOM node and set its download attribute */
        var encodedUri = encodeURI(csvContent);
        var link = document.createElement("a");
        link.setAttribute("href", encodedUri);
        link.setAttribute("download", "Requests_Report.csv");
        document.body.appendChild(link);
        link.click();
}

export default { exportData };