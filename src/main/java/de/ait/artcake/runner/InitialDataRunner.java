package de.ait.artcake.runner;

import de.ait.artcake.models.Cake;
import de.ait.artcake.models.User;
import de.ait.artcake.repositories.CakesRepository;
import de.ait.artcake.repositories.OrdersRepository;
import de.ait.artcake.repositories.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Profile("!test")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
@Component
public class InitialDataRunner implements CommandLineRunner {

    private UsersRepository usersRepository;

    private CakesRepository cakesRepository;

    private OrdersRepository ordersRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        log.info("InitialDataRunner start...");

        if(!usersRepository.existsByRole(User.Role.MANAGER)){
            User manager = User.builder()
                    .fullName("John Manageroff")
                    .email("manager@mail.com")
                    .hashPassword("$2a$10$VQky6jadkcnsisW/SSrqeuvP5p7Tomz5F7x/fMBzikyMGv7sfPOay")
//                    qwerty123!
                    .town("Kiel")
                    .street("StrandStrasse")
                    .houseNumber(21)
                    .phoneNumber("+4917688776655")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.MANAGER)
                    .build();

            usersRepository.save(manager);

            log.info("Insert manager into database");
        }

        if(!usersRepository.existsByRole(User.Role.CONFECTIONER)){
            User konditerow = User.builder()
                    .fullName("Konditer Konditerow")
                    .email("konditerow@gmail.com")
                    .hashPassword("$2a$10$XhZqBs2ID5aIey7WJJiPAexSGXcfuB6NFSb/ZC/S3GMkO/ouhmTdG")
                    .town("Kiel")
                    .street("StrandStrasse")
                    .houseNumber(78)
                    .phoneNumber("+4917688359755")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.CONFECTIONER)
                    .build();

            User konditeryan = User.builder()
                    .fullName("Konditer Konditeryan")
                    .email("konditeryan@gmail.com")
                    .hashPassword("$2a$10$jtLDeFSt7C1jNGtxpzh6kurTi.rej21OBRqjMexaC9jbW4JI967bC")
                    .town("Kiel")
                    .street("StrandStrasse")
                    .houseNumber(12)
                    .phoneNumber("+4917612359755")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.CONFECTIONER)
                    .build();

            User konditeridze = User.builder()
                    .fullName("Konditer Konditeridze")
                    .email("konditeridze@gmail.com")
                    .hashPassword("$2a$10$KrckCT.RKuAbniEAJoi2R.xIoeTHin/PEjuPH4qRVtTV9DStncu1K")
                    .town("Kiel")
                    .street("StrandStrasse")
                    .houseNumber(99)
                    .phoneNumber("+4917333359755")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.CONFECTIONER)
                    .build();

            User konditerenko = User.builder()
                    .fullName("Konditer Konditerenko")
                    .email("konditerenko@gmail.com")
                    .hashPassword("$2a$10$ruOLOFb6ugIquDl4iSv0DOVfSpC1orM5E512eitSFPoaJF03EfhP2")
                    .town("Kiel")
                    .street("StrandStrasse")
                    .houseNumber(19)
                    .phoneNumber("+4917612359755")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.CONFECTIONER)
                    .build();

            usersRepository.save(konditerow);
            usersRepository.save(konditeryan);
            usersRepository.save(konditeridze);
            usersRepository.save(konditerenko);

            log.info("Insert confectioners into database");
        }

        if(!cakesRepository.existsByCategory(Cake.Category.CHEESECAKES)) {
            Cake chocolateCheesecake = Cake.builder()
                    .name("Chocolate-Cheesecake")
                    .ingredients("cookies, chocolate, butter, cream-cheese, sugar, eggs, cream-35%")
                    .price(210.00)
                    .category(Cake.Category.CHEESECAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake raspberryCheesecake = Cake.builder()
                    .name("Raspberry-Cheesecake")
                    .ingredients("cookies, raspberry, butter, cream-cheese, sugar, eggs, cream-35%")
                    .price(170.00)
                    .category(Cake.Category.CHEESECAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake wildberriesCheesecake = Cake.builder()
                    .name("Wildberries-Cheesecake")
                    .ingredients("cookies, wildberries, butter, cream-cheese, sugar, eggs, cream-35%")
                    .price(170.00)
                    .category(Cake.Category.CHEESECAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake lillyCheesecake = Cake.builder()
                    .name("Lilly-Cheesecake")
                    .ingredients("cookies, lavender, butter, cream-cheese, sugar, eggs, cream-35%")
                    .price(160.00)
                    .category(Cake.Category.CHEESECAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake vanillaCheesecake = Cake.builder()
                    .name("Vanilla-Cheesecake")
                    .ingredients("cookies, vanilla, butter, cream-cheese, sugar, eggs, cream-35%")
                    .price(150.00)
                    .category(Cake.Category.CHEESECAKES)
                    .state(Cake.State.CREATED)
                    .build();

            cakesRepository.save(chocolateCheesecake);
            cakesRepository.save(wildberriesCheesecake);
            cakesRepository.save(raspberryCheesecake);
            cakesRepository.save(lillyCheesecake);
            cakesRepository.save(vanillaCheesecake);
        }

        if(!cakesRepository.existsByCategory(Cake.Category.CUPCAKES)) {
            Cake chocolateCupcake = Cake.builder()
                    .name("Chocolate-Cupcake")
                    .ingredients("butter, chocolate, sugar, eggs, flour, baking-powder")
                    .price(80.00)
                    .category(Cake.Category.CUPCAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake ferreroCupcake = Cake.builder()
                    .name("Ferrero-Cupcake")
                    .ingredients("butter, ferrero, sugar, eggs, flour, baking-powder")
                    .price(90.00)
                    .category(Cake.Category.CUPCAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake blackberryCupcake = Cake.builder()
                    .name("Blackberry-Cupcake")
                    .ingredients("butter, blackberry, sugar, eggs, flour, baking-powder")
                    .price(70.00)
                    .category(Cake.Category.CUPCAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake blueberryCupcake = Cake.builder()
                    .name("Blueberry-Cupcake")
                    .ingredients("butter, blueberry, sugar, eggs, flour, baking-powder")
                    .price(70.00)
                    .category(Cake.Category.CUPCAKES)
                    .state(Cake.State.CREATED)
                    .build();

            Cake wildberriesCupcake = Cake.builder()
                    .name("Wildberries-Cupcake")
                    .ingredients("butter, wildberries, sugar, eggs, flour, baking-powder")
                    .price(70.00)
                    .category(Cake.Category.CUPCAKES)
                    .state(Cake.State.CREATED)
                    .build();

            cakesRepository.save(chocolateCupcake);
            cakesRepository.save(ferreroCupcake);
            cakesRepository.save(blueberryCupcake);
            cakesRepository.save(blackberryCupcake);
            cakesRepository.save(wildberriesCupcake);
        }

        if(!cakesRepository.existsByCategory(Cake.Category.MACARONS)) {
            Cake chocolateMacarons = Cake.builder()
                    .name("Chocolate-Macarons")
                    .ingredients("egg-white, dark-chocolate, almond-flour, powdered-sugar baking-powder")
                    .price(95.00)
                    .category(Cake.Category.MACARONS)
                    .state(Cake.State.CREATED)
                    .build();

            Cake lemonMacarons = Cake.builder()
                    .name("Lemon-Macarons")
                    .ingredients("egg-white, lemon, almond-flour, powdered-sugar baking-powder")
                    .price(90.00)
                    .category(Cake.Category.MACARONS)
                    .state(Cake.State.CREATED)
                    .build();

            Cake velvetMacarons = Cake.builder()
                    .name("Velvet-Macarons")
                    .ingredients("egg-white, cherry, almond-flour, powdered-sugar baking-powder")
                    .price(95.00)
                    .category(Cake.Category.MACARONS)
                    .state(Cake.State.CREATED)
                    .build();

            Cake raspberriesMacarons = Cake.builder()
                    .name("Raspberries-Macarons")
                    .ingredients("egg-white, raspberries, almond-flour, powdered-sugar baking-powder")
                    .price(80.00)
                    .category(Cake.Category.MACARONS)
                    .state(Cake.State.CREATED)
                    .build();

            Cake bloodorangeMacarons = Cake.builder()
                    .name("Bloodorange-Macarons")
                    .ingredients("egg-white, bloodorange, almond-flour, powdered-sugar baking-powder")
                    .price(90.00)
                    .category(Cake.Category.MACARONS)
                    .state(Cake.State.CREATED)
                    .build();

            cakesRepository.save(chocolateMacarons);
            cakesRepository.save(raspberriesMacarons);
            cakesRepository.save(lemonMacarons);
            cakesRepository.save(velvetMacarons);
            cakesRepository.save(bloodorangeMacarons);
        }

        if(!cakesRepository.existsByCategory(Cake.Category.MOUSSE)) {
            Cake coconutMousse = Cake.builder()
                    .name("Coconut-Mousse")
                    .ingredients("sugar, coconut, eggs, flour, milk, gelatin, cream-35%")
                    .price(190.00)
                    .category(Cake.Category.MOUSSE)
                    .state(Cake.State.CREATED)
                    .build();

            Cake strawberryMousse = Cake.builder()
                    .name("Strawberry-Mousse")
                    .ingredients("sugar, strawberry, eggs, flour, milk, gelatin, cream-35%")
                    .price(180.00)
                    .category(Cake.Category.MOUSSE)
                    .state(Cake.State.CREATED)
                    .build();

            Cake blackberryMousse = Cake.builder()
                    .name("Blackberry-Mousse")
                    .ingredients("sugar, blackberry, eggs, flour, milk, gelatin, cream-35%")
                    .price(180.00)
                    .category(Cake.Category.MOUSSE)
                    .state(Cake.State.CREATED)
                    .build();

            Cake appleMousse = Cake.builder()
                    .name("Apple-Mousse")
                    .ingredients("sugar, apple, eggs, flour, milk, gelatin, cream-35%")
                    .price(180.00)
                    .category(Cake.Category.MOUSSE)
                    .state(Cake.State.CREATED)
                    .build();

            Cake raspberryMousse = Cake.builder()
                    .name("Raspberry-Mousse")
                    .ingredients("sugar, raspberry, eggs, flour, milk, gelatin, cream-35%")
                    .price(180.00)
                    .category(Cake.Category.MOUSSE)
                    .state(Cake.State.CREATED)
                    .build();

            cakesRepository.save(coconutMousse);
            cakesRepository.save(strawberryMousse);
            cakesRepository.save(appleMousse);
            cakesRepository.save(raspberryMousse);
            cakesRepository.save(blackberryMousse);
        }

        //if(usersRepository.count() == 5) {
        //    User client = User.builder()
        //            .fullName("Client Clientowitsch")
        //            .email("client@gmail.com")
        //            .hashPassword("$2a$10$x4x5qCBkKBUMsYpUpOJYw.GxFbFgSBHryob0sHZOTB4Rl8DmwP1M6")
        //            .town("Kiel")
        //            .street("StrandStrasse")
        //            .houseNumber(7)
        //            .phoneNumber("+4917688777755")
        //            .state(User.State.CONFIRMED)
        //            .role(User.Role.CLIENT)
        //            .build();
        //
        //    usersRepository.save(client);
        //
        //    log.info("Insert a client into database");
        //}


    }
}