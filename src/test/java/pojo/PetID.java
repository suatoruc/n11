package pojo;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PetID {
    private int id;
    private Category category;
    private String name;
    private ArrayList<String> photoUrls;
    private  ArrayList<Tags> tags;
    private String status;



}
