/* eslint-disable no-unused-vars */
import { useEffect, useState } from "react";
import ProjectCard from "./ProjectCard";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import {
  MagnifyingGlassIcon,
  MixerHorizontalIcon,
} from "@radix-ui/react-icons";
import { Card, CardContent } from "@/components/ui/card";
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";
import { Label } from "@/components/ui/label";
import { ScrollArea } from "@/components/ui/scroll-area";

import { useDispatch, useSelector } from "react-redux";
import { fetchProjects, searchProjects } from "@/redux/Project/Project.Action";
import { useLocation, useNavigate } from "react-router-dom";
import { tags } from "./filterData";

import {
  Sheet,
  SheetContent,
  SheetTrigger,
} from "@/components/ui/sheet";

import FilterSheet from "./FilterSheet";

const ProjectList = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const dispatch = useDispatch();

  const searchParams = new URLSearchParams(location.search);
  const category = searchParams.get("category");
  const tag = searchParams.get("tag");

  const [keyword, setKeyword] = useState("");

  const project = useSelector((store) => store.project);
  const auth = useSelector((store) => store.auth);

  useEffect(() => {
    dispatch(fetchProjects({ category, tag }));
  }, [category, tag, auth.jwt]);

  const handleFilterChange = (section, value) => {
    if (value === "all") {
      searchParams.delete(section);
    } else {
      searchParams.set(section, value);
    }

    const query = searchParams.toString();
    navigate({ search: query ? `?${query}` : "" });
  };

  const handleSearchChange = (e) => {
    setKeyword(e.target.value);

    if (e.target.value) {
      dispatch(searchProjects(e.target.value));
    }
  };

  return (
    <>
      <div className="relative px-5 lg:px-0 lg:flex gap-5 justify-center py-5">
        
        {/* ---------- LEFT FILTER PANEL (LARGE SCREEN) ---------- */}
        <section className="hidden lg:block">
          <Card className="p-5 sticky top-10">
            <div className="flex justify-between lg:w-[20rem]">
              <p className="text-xl tracking-wider">filters</p>
              <Button variant="ghost" size="icon">
                <MixerHorizontalIcon />
              </Button>
            </div>

            <CardContent className="mt-5 ">
              <ScrollArea className="space-y-7 h-[70vh]">
                
                {/* Category */}
                <div>
                  <h1 className="pb-3 text-gray-400 border-b">Category</h1>
                  <div className="pt-5">
                    <RadioGroup
                      onValueChange={(value) => handleFilterChange("category", value)}
                      className="space-y-3"
                      defaultValue={category || "all"}
                    >
                      <div className="flex items-center space-x-2">
                        <RadioGroupItem value="all" id="cat-all" />
                        <Label htmlFor="cat-all">all</Label>
                      </div>

                      <div className="flex items-center space-x-2">
                        <RadioGroupItem value="fullstack" id="cat-full" />
                        <Label htmlFor="cat-full">full stack</Label>
                      </div>

                      <div className="flex items-center space-x-2">
                        <RadioGroupItem value="frontend" id="cat-front" />
                        <Label htmlFor="cat-front">frontend</Label>
                      </div>

                      <div className="flex items-center space-x-2">
                        <RadioGroupItem value="backend" id="cat-back" />
                        <Label htmlFor="cat-back">backend</Label>
                      </div>
                    </RadioGroup>
                  </div>
                </div>

                {/* Tags */}
                <div className="pt-9">
                  <h1 className="pb-3 text-gray-400 border-b">Tags</h1>

                  <RadioGroup
                    onValueChange={(value) => handleFilterChange("tag", value)}
                    className="space-y-3 pt-5"
                    defaultValue={tag || "all"}
                  >
                    {tags.map((item) => (
                      <div key={item} className="flex items-center space-x-2">
                        <RadioGroupItem value={item} id={`tag-${item}`} />
                        <Label htmlFor={`tag-${item}`}>{item}</Label>
                      </div>
                    ))}
                  </RadioGroup>
                </div>
              </ScrollArea>
            </CardContent>
          </Card>
        </section>

        {/* ---------- MAIN PROJECT AREA ---------- */}
        <section className="w-full lg:w-[48rem]">
          
          {/* Search + Filter Button */}
          <div className="flex gap-2 items-center pb-5 justify-between">
            <div className="relative p-0 w-full">
              <Input
                className="w-[40%] rounded-full px-9"
                placeholder="search project..."
                onChange={handleSearchChange}
              />
              <MagnifyingGlassIcon className="absolute top-3 left-4" />
            </div>

            {/* Mobile Filter Drawer */}
            <Sheet className="lg:hidden">
              <SheetTrigger asChild>
                <Button variant="ghost" size="icon">
                  <MixerHorizontalIcon />
                </Button>
              </SheetTrigger>

              <SheetContent>
                <FilterSheet />
              </SheetContent>
            </Sheet>
          </div>

          {/* Projects */}
          <div>
            <div className="space-y-5 min-h-[74vh]">
              {keyword
                ? project.searchProjects.map((item) => (
                    <ProjectCard item={item} key={item.id} />
                  ))
                : project.projects.map((item) => (
                    <ProjectCard item={item} key={item.id} />
                  ))}
            </div>

            {/* If no project */}
            {project.projects.length === 0 && keyword === "" && (
              <div className="flex items-center justify-center h-[80vh]">
                <h1>No projects...</h1>
              </div>
            )}
          </div>
        </section>
      </div>
    </>
  );
};

export default ProjectList;
