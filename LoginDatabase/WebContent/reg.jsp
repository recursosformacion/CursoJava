<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form method="post" action="registro.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Indiquenos sus datos</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellido</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Cod. Usuario</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Enviar" /></td>
                        <td><input type="reset" value="Cancelar" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Ya estáregistrado!! <a href="index.jsp">Identifiquese aqui</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>