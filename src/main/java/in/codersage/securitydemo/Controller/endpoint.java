package in.codersage.securitydemo.Controller;

import in.codersage.securitydemo.Entity.assignment1;
import in.codersage.securitydemo.Repository.assignment1Repo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@RestController
public class endpoint {

    @Autowired
    in.codersage.securitydemo.Repository.assignment1Repo assignment1Repo;

    @GetMapping("{ID}/generate")
    public String generate(@PathVariable("ID") String id){

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        assignment1 assignment1 = new assignment1();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);

        String filename = "D:\\College\\Assignment Project\\spring_boot_auth_mysql_OAuth-master\\Files\\"+id+".txt";

        Path path = Paths.get(filename);
        String content = generatedString;

        try{
            Files.createFile(path);
            Files.writeString(path,content, StandardCharsets.UTF_8);
            System.out.println("FIle created");
        }catch (IOException ex){
            System.out.println("Error occured"+ ex);
        }

        assignment1.setRandomString(generatedString);
        assignment1.setID(id);

        assignment1Repo.save(assignment1);



        // assignment1Repo.save(assignment1);


        return "Generated String";
    }

    @RequestMapping("/download/file/{ID}")
    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
                                    @PathVariable("ID") String id) throws IOException {

        System.out.println("Heyy I am in");

        File file = new File("D:\\College\\Assignment Project\\spring_boot_auth_mysql_OAuth-master\\Files\\" + id+".txt");
        if (file.exists()) {

            //get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                //unknown mimetype so set the mimetype to application/octet-stream
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);

            /**
             * In a regular HTTP response, the Content-Disposition response header is a
             * header indicating if the content is expected to be displayed inline in the
             * browser, that is, as a Web page or as part of a Web page, or as an
             * attachment, that is downloaded and saved locally.
             *
             */

            /**
             * Here we have mentioned it to show inline
             */
//            response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

            //Here we have mentioned it to show as attachment
            response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());

        }
    }


}