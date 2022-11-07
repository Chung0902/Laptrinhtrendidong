package com.example.app;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FireBaseDatabaseHelper {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRederenceFashions;
    private List<Fashion> fashions = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Fashion> fashions, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }
    public FireBaseDatabaseHelper() {
        mDatabase =FirebaseDatabase.getInstance();
        mRederenceFashions = mDatabase.getReference("sinhvien");
    }

    public void readFashions(final DataStatus dataStatus){
        mRederenceFashions.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fashions.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Fashion fashion = keyNode.getValue(Fashion.class);
                    fashions.add(fashion);
                }
                dataStatus.DataIsLoaded(fashions,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void addFashion(Fashion fashion,final DataStatus dataStatus){
        String key=mRederenceFashions.push().getKey();
        mRederenceFashions.child(key).setValue(fashion).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsInserted();
            }
        });
    }

    public void updateFashion(String key,Fashion fashion, final DataStatus dataStatus){
        mRederenceFashions.child(key).setValue(fashion).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void deleteFashion(String key,final DataStatus dataStatus){
        mRederenceFashions.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}
