package com.example.parksinyoung.moblieprogramming_syjy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.parksinyoung.moblieprogramming_syjy.model.OnDataChangedListener;
import com.example.parksinyoung.moblieprogramming_syjy.model.PostModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


public abstract class BaseBoardFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_base_board, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.board_recycler_view);
        setHasOptionsMenu(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.scrollToPositionWithOffset(0, 0);
        recyclerView.setLayoutManager(linearLayoutManager);

//        showProgressDialog();

        setAdapter(getRef());

        return view;
    }

    public abstract DatabaseReference getRef();

    public abstract String getPostType();

    @Override
    public void onCreateOptionsMenu( final Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_board, menu);


        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("제목으로 검색");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Query query = getRef().orderByChild("title").startAt(s).endAt(s + "\uf8ff");
                setAdapter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.length() == 0)
                    setAdapter(getRef());
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        setAdapter(getRef());
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_write) {
            Intent intent = new Intent(getActivity(), BoardWriteActivity.class);
            intent.putExtra("CURRENT_BOARD_TAB", BoardTabFragment.getCurrentTab());
            startActivity(intent);
        }
        return true;
    }

    public void setAdapter(Query query) {
        showProgressDialog();
        PostModel postModel = new PostModel(getPostType());
        postModel.setOnDataChangedListener(new OnDataChangedListener() {
            @Override
            public void onDataChanged() {
//                recyclerView.getLayoutManager().scrollToPosition(recyclerView.getAdapter().getItemCount() - 1);//새글 작성시 스크롤 최상단으로 이동

                progressDialog.dismiss();
            }
        });

        recyclerView.setAdapter(postModel.setAdapter(query, getPostType()));
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading..");
        progressDialog.show();
    }

}