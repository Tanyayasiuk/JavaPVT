package FinalProject;

public class Main {

    public static void main(String[] args) {

        //Скачиваниие файлов с  расписанием
        Downloader.download();

        if (Downloader.isOk){
            //Создание нового расписания
            Root root = Root.getInstance();

            try{
                //Парсинг из файла
                root = ParseJSON.parseGson("D:\\JavaOffline\\src\\FinalProject\\bus_schedule.json");
                //root = ParseXML.parseDom("D:\\JavaOffline\\src\\FinalProject\\bus_schedule.xml");
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            // Работа с пользователем
            if(root != null) {
                UI ui = new UI();
                ui.startUI(root);
            }
        }

    }
}
