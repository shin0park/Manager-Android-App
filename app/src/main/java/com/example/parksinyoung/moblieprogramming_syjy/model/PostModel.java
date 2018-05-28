package com.example.parksinyoung.moblieprogramming_syjy.model;

import com.example.parksinyoung.moblieprogramming_syjy.R;
import com.example.parksinyoung.moblieprogramming_syjy.singleton.Post;
import com.example.parksinyoung.moblieprogramming_syjy.viewholder.PostViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PostModel {
    private DatabaseReference databaseReference;
    private OnDataChangedListener onDataChangedListener;

    public void setOnDataChangedListener(OnDataChangedListener listener) {
        this.onDataChangedListener = listener;
    }


    public PostModel(String postType) {
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(postType).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (onDataChangedListener != null) {
                    onDataChangedListener.onDataChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

    public void writePost( String postType, String userName, String title, String contents) {
        databaseReference.child(postType).
                push().setValue(Post.newPost(userName, title, contents, 0));
    }

    public void correctPost( String postType, String userName, String title, String contents, String postKey, int commentCount) {
        databaseReference.child(postType).
                child(postKey).setValue(Post.newPost(userName, title, contents, commentCount));

    }

    public FirebaseRecyclerAdapter setAdapter( Query query, final String postType) {

        FirebaseRecyclerAdapter<Post, PostViewHolder> adapter = new FirebaseRecyclerAdapter<Post, PostViewHolder>(Post.class, R.layout.list_item_post,
                PostViewHolder.class, query) {
            @Override
            protected void populateViewHolder(PostViewHolder viewHolder, Post model, int position) {
                DatabaseReference postRef = getRef(position);
                String postKey = postRef.getKey();
                viewHolder.bindPost(model, postKey, postType);
            }
        };

        return adapter;
    }
}
